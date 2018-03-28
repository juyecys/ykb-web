package cn.com.yikangbao.service.notification;

import cn.com.yikangbao.entity.message.Message;
import cn.com.yikangbao.entity.wechat.message.WechatCustomMessage;
import cn.com.yikangbao.entity.wechat.message.WechatTemplateMessage;
import cn.com.yikangbao.entity.wechat.result.WechatCommonResult;

import java.io.IOException;
import java.util.List;

/**
 * Created by jeysine on 2018/3/27.
 */
public interface WechatNotificationService {
    WechatCommonResult pushMessage(WechatCustomMessage wechatCustomMessage) throws IOException;

    WechatCommonResult pushNewsMessage(String openId, List<WechatCustomMessage.News.Article> articleList) throws IOException;

    WechatCommonResult pushTextMessage(String openId, String content) throws IOException;

    WechatCommonResult pushImageMessage(String openId, String mediaId) throws IOException;

    WechatCommonResult pushMessageByMessage(String openId, Message message) throws IOException;

    WechatCommonResult pushTemplateMessage(WechatTemplateMessage wechatTemplateMessage) throws IOException;

    void pushMessageListByMessage(String openId, List<Message> message) throws IOException;

}
