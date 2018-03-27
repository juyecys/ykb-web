package cn.com.yikangbao.service.wechat.jssign.impl;

import cn.com.yikangbao.config.wechat.WechatConfigSecret;
import cn.com.yikangbao.entity.wechat.jssign.WechatJsSign;
import cn.com.yikangbao.service.wechat.jssign.WechatJsSignService;
import cn.com.yikangbao.service.wechat.jsticket.WechatJsTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.Formatter;
import java.util.UUID;

/**
 * Created by jeysine on 2018/3/26.
 */
@Service("wechatJsSignService")
public class WechatJsSignServiceImpl implements WechatJsSignService {

    @Autowired
    private WechatJsTicketService wechatJsTicketService;

    @Override
    public WechatJsSign signUrl(String url) throws Exception {

        String jsApiTicket = wechatJsTicketService.getJsTicket().getTicket();

        String nonceStr = createNonceStr();
        String timestamp = getTimeStamp();
        String signature = "";

        // 注意这里参数名必须全部小写，且必须有序
        String string1 = "jsapi_ticket=" + jsApiTicket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url="
                + url;


        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(string1.getBytes("UTF-8"));
        signature = byteToHex(crypt.digest());

        WechatJsSign sign = new WechatJsSign();
        sign.setUrl(url);
        sign.setJsapiTicket(jsApiTicket);
        sign.setSignature(signature);
        sign.setTimestamp(timestamp);
        sign.setNonceStr(nonceStr);
        sign.setAppId(WechatConfigSecret.getWechatAppid());

        return sign;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();

        return result;
    }

    private static String createNonceStr() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    private static String getTimeStamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}
