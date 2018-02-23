package cn.com.yikangbao.service.message.impl;

import cn.com.yikangbao.entity.message.Article;
import cn.com.yikangbao.entity.message.Message;
import cn.com.yikangbao.entity.message.MessageDTO;
import cn.com.yikangbao.entity.wechat.message.WechatCustomMessage;
import cn.com.yikangbao.mongo.dao.message.MessageDAO;
import cn.com.yikangbao.service.message.MessageService;
import cn.com.yikangbao.service.wechat.message.WechatMessageService;
import cn.com.yikangbao.untils.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * Created by jeysine on 2018/2/9.
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDAO dao;

    @Autowired
    private WechatMessageService wechatMessageService2;

    private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Override
    public void pushMessage(String openId, Message message) throws IOException {
        Message.MsgTypeEnum msgTypeEnum = Message.MsgTypeEnum.getEnumByValue(message.getMsgType());
        switch (msgTypeEnum) {
            case TEXT:
                wechatMessageService2.pushTextMessage(openId, message.getContent());
                break;
            case IMAGE:
                break;
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
                wechatMessageService2.pushNewsMessage(openId, list);
                break;
        }
    }

    @Override
    public void pushMessageList(String openId, List<Message> messageList) throws IOException {
        if (!StringUtil.isEmpty(openId) && !messageList.isEmpty()) {
            for(Message message: messageList) {
                pushMessage(openId, message);
            }
        }
    }

    @Override
    public void pushSubscribeMessage(String openid) throws IOException {
        List<Message> messageList = findByStatusAndTypeOrderBySequence(true, Message.TypeEnum.SUBSCRIBE.name());
        logger.debug("subscribe messageList: {}", messageList);
        pushMessageList(openid, messageList);
    }

    @Override
    public void pushChannelsMessage(String openId, String qrCodeScene) throws IOException {
        List<Message> messageList = findByStatusAndTypeAndQrCodeSceneOrderBySequence(true, Message.TypeEnum.CHANNEL.name(), qrCodeScene);
        pushMessageList(openId, messageList);
    }

    @Override
    public Message createOrUpdate(Message message) {
        if (message.getId() == null) {
            message.setId(UUID.randomUUID().toString());
        }
        create(message);
        return message;
    }

    @Override
    public List<Message> findByStatusOrderBySequence(Boolean status) {
        return dao.findByStatusOrderBySequence(status);
    }

    @Override
    public List<Message> findByTypeAndQrCodeScene(String type, String qrCodeScene) {
        return dao.findByTypeAndQrCodeScene(type, qrCodeScene);
    }

    @Override
    public List<Message> findByStatusAndTypeOrderBySequence(Boolean status, String type) {
        return dao.findByStatusAndTypeOrderBySequence(status, type);
    }

    @Override
    public List<Message> findByStatusAndTypeAndQrCodeSceneOrderBySequence(Boolean status, String type, String qrCodeScene) {
        return dao.findByStatusAndTypeAndQrCodeSceneOrderBySequence(status, type, qrCodeScene);
    }

    @Override
    public Message create(Message entity) {
        return dao.save(entity);
    }

    @Override
    public List<Message> findAll() {
        return (List<Message>) dao.findAll();
    }

    @Override
    public List<Message> findAll(Sort var1) {
        return null;
    }

    @Override
    public void delete(String id) {
        dao.delete(id);
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
