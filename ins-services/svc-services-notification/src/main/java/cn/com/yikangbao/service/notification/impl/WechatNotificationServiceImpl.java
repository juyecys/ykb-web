package cn.com.yikangbao.service.notification.impl;

import cn.com.yikangbao.entity.message.Article;
import cn.com.yikangbao.entity.message.Message;
import cn.com.yikangbao.entity.message.TemplateMessage;
import cn.com.yikangbao.entity.wechat.message.WechatCustomMessage;
import cn.com.yikangbao.entity.wechat.message.WechatTemplateMessage;
import cn.com.yikangbao.entity.wechat.result.WechatCommonResult;
import cn.com.yikangbao.service.message.MessageService;
import cn.com.yikangbao.service.notification.WechatNotificationService;
import cn.com.yikangbao.service.wechat.message.WechatMessageService;
import cn.com.yikangbao.untils.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by jeysine on 2018/3/27.
 */
@Service("wechatNotificationService")
public class WechatNotificationServiceImpl implements WechatNotificationService {

    @Autowired
    private WechatMessageService wechatMessageServiceRPC;

    @Autowired
    private MessageService messageService;


    private Logger logger = LoggerFactory.getLogger(WechatNotificationServiceImpl.class);

    @Override
    public WechatCommonResult pushMessage(WechatCustomMessage wechatCustomMessage) throws IOException {
        return wechatMessageServiceRPC.pushMessage(wechatCustomMessage);
    }

    @Override
    public WechatCommonResult pushNewsMessage(String openId, List<WechatCustomMessage.News.Article> articleList) throws IOException {
        WechatCustomMessage message = new WechatCustomMessage();

        WechatCustomMessage.News news = message.new News();

        news.setArticles(articleList);

        message.setTouser(openId);
        message.setNews(news);
        message.setMsgtype(WechatCustomMessage.MsgTypeEnum.NEWS.getValue());
        return pushMessage(message);
    }

    @Override
    public WechatCommonResult pushTextMessage(String openId, String content) throws IOException {
        WechatCustomMessage message = new WechatCustomMessage();
        WechatCustomMessage.Text text = message.new Text();
        text.setContent(content);
        message.setTouser(openId);
        message.setText(text);
        message.setMsgtype(WechatCustomMessage.MsgTypeEnum.TEXT.getValue());
        return pushMessage(message);
    }

    @Override
    public WechatCommonResult pushImageMessage(String openId, String mediaId) throws IOException {
        WechatCustomMessage message = new WechatCustomMessage();
        WechatCustomMessage.Image image = message.new Image();
        image.setMediaId(mediaId);

        message.setTouser(openId);
        message.setImage(image);
        message.setMsgtype(WechatCustomMessage.MsgTypeEnum.IMAGE.getValue());
        return pushMessage(message);
    }

    @Override
    public WechatCommonResult pushMessageByMessage(String openId, Message message) throws IOException {
        Message.MsgTypeEnum msgTypeEnum = Message.MsgTypeEnum.getEnumByValue(message.getMsgType());
        switch (msgTypeEnum) {
            case TEXT:
                return pushTextMessage(openId, message.getContent());
            case IMAGE:
                return pushImageMessage(openId, message.getMediaId());
            case MUSIC:
                break;
            case VIDEO:
                break;
            case VOICE:
                break;
            case MPNEWS:
                break;
            case WXCARD:
                break;
            case ARTICLE:
            case ARTICLE_LIST:
                List<WechatCustomMessage.News.Article> list = generateArticleList(message.getArticleList());
                return pushNewsMessage(openId, list);
            case TEMPLATE:
                return pushTemplateMessageByMessage(openId, message);
            default: return null;
        }

        return null;
    }

    @Override
    public WechatCommonResult pushTemplateMessage(WechatTemplateMessage wechatTemplateMessage) throws IOException {
        return wechatMessageServiceRPC.pushTemplateMessage(wechatTemplateMessage);
    }

    @Override
    public WechatCommonResult pushTemplateMessageByMessage(String openId, Message message) throws IOException {
        if (message != null && message.getTemplateMessage() != null) {
            TemplateMessage templateMessage = message.getTemplateMessage();
            WechatTemplateMessage wechatTemplateMessage = new WechatTemplateMessage();
            wechatTemplateMessage.setTemplateId(templateMessage.getTemplateId());
            wechatTemplateMessage.setTouser(openId);
            wechatTemplateMessage.setUrl(templateMessage.getUrl());
            wechatTemplateMessage.setMiniProgram(templateMessage.getMiniProgram());

            WechatTemplateMessage.Data data = wechatTemplateMessage.new Data();
            WechatTemplateMessage.DataContent first = wechatTemplateMessage.new DataContent();
            first.setValue(templateMessage.getFirst());
            data.setFirst(first);

            WechatTemplateMessage.DataContent keyWord1 = wechatTemplateMessage.new DataContent();
            keyWord1.setValue(templateMessage.getKeyword1());
            data.setKeyword1(keyWord1);

            if (templateMessage.getKeyword2() != null) {
                WechatTemplateMessage.DataContent keyWord2 = wechatTemplateMessage.new DataContent();
                keyWord2.setValue(templateMessage.getKeyword2());
                data.setKeyword2(keyWord2);
            }

            if (templateMessage.getKeyword3() != null) {
                WechatTemplateMessage.DataContent keyWord3 = wechatTemplateMessage.new DataContent();
                keyWord3.setValue(templateMessage.getKeyword3());
                data.setKeyword3(keyWord3);
            }

            if (templateMessage.getKeyword4() != null) {
                WechatTemplateMessage.DataContent keyWord4 = wechatTemplateMessage.new DataContent();
                keyWord4.setValue(templateMessage.getKeyword4());
                data.setKeyword4(keyWord4);
            }

            if (templateMessage.getKeyword5() != null) {
                WechatTemplateMessage.DataContent keyWord5 = wechatTemplateMessage.new DataContent();
                keyWord5.setValue(templateMessage.getKeyword5());
                data.setKeyword5(keyWord5);
            }

            if (templateMessage.getRemark() != null) {
                WechatTemplateMessage.DataContent remark = wechatTemplateMessage.new DataContent();
                remark.setValue(templateMessage.getRemark());
                data.setKeyword5(remark);
            }

            wechatTemplateMessage.setData(data);
            return pushTemplateMessage(wechatTemplateMessage);
        }
        return null;
    }

    @Override
    public void pushMessageListByMessage(String openId, List<Message> messageList) throws IOException {
        if (!StringUtil.isEmpty(openId) && !messageList.isEmpty()) {
            for(Message message: messageList) {
                pushMessageByMessage(openId, message);
            }
        }
    }

    private List<WechatCustomMessage.News.Article> generateArticleList(List<Article> articles) {
        WechatCustomMessage wechatCustomMessage = new WechatCustomMessage();
        WechatCustomMessage.News news = wechatCustomMessage.new News();
        WechatCustomMessage.News.Article article = news.new Article();
        List<WechatCustomMessage.News.Article> list = new LinkedList<>();
        for (Article one: articles) {
            article.setUrl(one.getUrl());
            article.setDescription(one.getDescription());
            article.setPicurl(one.getPicUrl());
            article.setTitle(one.getTitle());
            list.add(article);
        }
        return list;
    }

    @Override
    public void pushSubscribeMessage(String openid) throws IOException {
        List<Message> messageList = messageService.findByStatusAndTypeOrderBySequence(true, Message.TypeEnum.SUBSCRIBE.name());
        logger.debug("subscribe messageList: {}", messageList);
        pushMessageListByMessage(openid, messageList);
    }

    @Override
    public void pushChannelsMessage(String openId, String qrCodeScene) throws IOException {
        List<Message> messageList = messageService.findByStatusAndTypeAndQrCodeSceneOrderBySequence(true, Message.TypeEnum.CHANNEL.name(), qrCodeScene);
        logger.debug("channel messageList: {}", messageList);
        pushMessageListByMessage(openId, messageList);
    }
}
