package cn.com.yikangbao.service.notification.impl;

import cn.com.yikangbao.entity.message.Article;
import cn.com.yikangbao.entity.message.Message;
import cn.com.yikangbao.entity.wechat.message.WechatCustomMessage;
import cn.com.yikangbao.entity.wechat.message.WechatTemplateMessage;
import cn.com.yikangbao.entity.wechat.result.WechatCommonResult;
import cn.com.yikangbao.service.notification.WechatNotificationService;
import cn.com.yikangbao.service.wechat.message.WechatMessageService;
import cn.com.yikangbao.untils.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jeysine on 2018/3/27.
 */
@Service("wechatNotificationService")
public class WechatNotificationServiceImpl implements WechatNotificationService {

    @Autowired
    private WechatMessageService wechatMessageServiceRPC;

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
            default: return null;
        }

        return null;
    }

    @Override
    public WechatCommonResult pushTemplateMessage(WechatTemplateMessage wechatTemplateMessage) throws IOException {
        return wechatMessageServiceRPC.pushTemplateMessage(wechatTemplateMessage);
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
}
