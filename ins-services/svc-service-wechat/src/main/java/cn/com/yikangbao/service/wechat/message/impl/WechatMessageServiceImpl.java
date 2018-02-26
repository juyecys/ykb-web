package cn.com.yikangbao.service.wechat.message.impl;

import cn.com.yikangbao.contants.wechat.WechatConfigParams;
import cn.com.yikangbao.entity.message.Article;
import cn.com.yikangbao.entity.message.Message;
import cn.com.yikangbao.entity.wechat.acesstoken.WechatAccessToken;
import cn.com.yikangbao.entity.wechat.localwechatmenu.LocalWechatMenu;
import cn.com.yikangbao.entity.wechat.message.WechatCustomMessage;
import cn.com.yikangbao.entity.wechat.result.WechatCommonResult;
import cn.com.yikangbao.service.message.MessageService;
import cn.com.yikangbao.service.wechat.accesstoken.WechatAccessTokenService;
import cn.com.yikangbao.service.wechat.message.WechatMessageService;
import cn.com.yikangbao.untils.common.AliyunContentStorageUtils;
import cn.com.yikangbao.untils.common.StringUtil;
import cn.com.yikangbao.untils.common.okhttputil.OkHttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jeysine on 2018/1/25.
 */
@Service("wechatMessageService")
public class WechatMessageServiceImpl implements WechatMessageService {

    @Autowired
    private WechatAccessTokenService wechatAccessTokenService;

    @Autowired
    private MessageService messageService;

    private static final ObjectMapper mapper = new ObjectMapper();

    private Logger logger = LoggerFactory.getLogger(WechatMessageServiceImpl.class);
    @Override
    public WechatCommonResult pushMessage(WechatCustomMessage wechatCustomMessage) throws IOException {
        WechatAccessToken accessToken = wechatAccessTokenService.getAccessToken();
        String url = WechatConfigParams.WECHAT_CUSTOM_MESSAGE.replace("ACCESS_TOKEN", accessToken.getAccessToken());
        String messageJson = mapper.writeValueAsString(wechatCustomMessage);
        logger.debug("send message to wechat user: {}", messageJson);
        String result = OkHttpUtils.postString().url(url).content(messageJson).build().execute().body().string();
        logger.debug("send message to wechat user result: {}", result);
        return mapper.readValue(result,WechatCommonResult.class);
    }

    @Override
    public WechatCommonResult pushNewsMessageByMenuEvent(String openId, LocalWechatMenu menu) throws IOException {
        WechatCustomMessage message = new WechatCustomMessage();

        WechatCustomMessage.News news = message.new News();

        WechatCustomMessage.News.Article articl = news.new Article();
        List<WechatCustomMessage.News.Article> articls = new LinkedList<>();
        articl.setDescription(menu.getContent());
        articl.setTitle(menu.getTitle());
        articl.setPicurl(AliyunContentStorageUtils.getFullAccessUrlForKey(menu.getImgUrl()));
        articl.setUrl(menu.getUrl());
        articls.add(articl);

        news.setArticles(articls);
        return pushNewsMessage(openId, articls);
    }

    @Override
    public WechatCommonResult pushTextMessageByMenuEvent(String openId, LocalWechatMenu menu) throws IOException {
        return pushTextMessage(openId, menu.getContent());
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
    public void pushMessageByMessage(String openId, Message message) throws IOException {
        Message.MsgTypeEnum msgTypeEnum = Message.MsgTypeEnum.getEnumByValue(message.getMsgType());
        switch (msgTypeEnum) {
            case TEXT:
                pushTextMessage(openId, message.getContent());
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
                pushNewsMessage(openId, list);
                break;
        }
    }

    @Override
    public void pushMessageListByMessage(String openId, List<Message> messageList) throws IOException {
        if (!StringUtil.isEmpty(openId) && !messageList.isEmpty()) {
            for(Message message: messageList) {
                pushMessageByMessage(openId, message);
            }
        }
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
        pushMessageListByMessage(openId, messageList);
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
