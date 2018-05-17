package cn.com.yikangbao.utils.common;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SendmailUtil {
/*
    mail.mailsender=it@chengyisheng.com.cn
    mail.kefu=kf@chengyisheng.com.cn
    mail.mailPassword=Cyscysit123
    mail.mailHost=smtp.exmail.qq.com*/

    // 设置服务
    private static String KEY_SMTP = "mail.smtp.host";
    private static String VALUE_SMTP = "smtp.exmail.qq.com";
    // 服务器验证
    private static String KEY_PROPS = "mail.smtp.auth";
    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    private static boolean VALUE_PROPS = true;
    // 发件人用户名、密码
    private String SEND_USER = "it@chengyisheng.com.cn";
    private String SEND_UNAME = "it@chengyisheng.com.cn";
    private String SEND_PWD = "Cyscysit123";
    // 建立会话
    private MimeMessage message;
    private Session s;

    /*
     * 初始化方法
     */
    public SendmailUtil() {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.host", "smtp.exmail.qq.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        //邮箱发送服务器端口,这里设置为465端口
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");

        s =  Session.getDefaultInstance(props, new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SEND_UNAME, SEND_PWD);
            }});
        s.setDebug(true);
        message = new MimeMessage(s);
    }

    /**
     * 发送邮件
     *
     * @param headName
     *            邮件头文件名
     * @param sendHtml
     *            邮件内容
     * @param receiveUser
     *            收件人地址
     */
    public void doSendHtmlEmail(String headName, String sendHtml,
                                String receiveUser) throws MessagingException {
            // 发件人
        InternetAddress from = new InternetAddress(SEND_USER);
        message.setFrom(from);
        // 收件人
        InternetAddress to = new InternetAddress(receiveUser);
        message.setRecipient(Message.RecipientType.TO, to);
        // 邮件标题
        message.setSubject(headName);
        String content = sendHtml.toString();
        // 邮件内容,也可以使纯文本"text/plain"
        message.setContent(content, "text/html;charset=GBK");
        message.saveChanges();
        Transport transport = s.getTransport("smtp");
        // smtp验证，就是你用来发邮件的邮箱用户名密码
        transport.connect(VALUE_SMTP, SEND_UNAME, SEND_PWD);
        // 发送
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        System.out.println("send success!");
    }

    public void doSendHtmlEmail(String headName, String sendHtml,
                                List<String> receiveList) throws MessagingException {
        // 发件人
        InternetAddress from = new InternetAddress(SEND_USER);
        message.setFrom(from);
        // 收件人
        InternetAddress[] to = new InternetAddress[receiveList.size()];
        for(int i = 0; i < receiveList.size(); i++){
            to[i] = new InternetAddress(receiveList.get(i));
        }
        message.setRecipients(Message.RecipientType.TO, to);
        // 邮件标题
        message.setSubject(headName);
        String content = sendHtml.toString();
        // 邮件内容,也可以使纯文本"text/plain"
        message.setContent(content, "text/html;charset=GBK");
        message.saveChanges();
        Transport transport = s.getTransport("smtp");
        // smtp验证，就是你用来发邮件的邮箱用户名密码
        transport.connect(VALUE_SMTP, SEND_UNAME, SEND_PWD);
        // 发送
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        System.out.println("send success!");
    }

    public static void main(String[] args) throws MessagingException {
        SendmailUtil se = new SendmailUtil();
        List<String> receiveList = new ArrayList<>();
        receiveList.add("wangtengye@huduo.tech");
        se.doSendHtmlEmail("邮件头文件名", "<p>hello world</p>", receiveList);
    }
}//源代码片段来自云代码http://yuncode.net

