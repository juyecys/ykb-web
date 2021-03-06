package cn.com.yikangbao.service.wechat.message;

import cn.com.yikangbao.entity.message.Message;
import cn.com.yikangbao.entity.wechat.localwechatmenu.LocalWechatMenu;
import cn.com.yikangbao.entity.wechat.message.WechatCustomMessage;
import cn.com.yikangbao.entity.wechat.result.WechatCommonResult;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.List;

/**
 * Created by jeysine on 2018/1/25.
 */
public interface WechatMessageService {
    WechatCommonResult pushMessage(WechatCustomMessage wechatCustomMessage) throws IOException;

    WechatCommonResult pushNewsMessageByMenuEvent(String openId, LocalWechatMenu menu) throws IOException;

    WechatCommonResult pushTextMessageByMenuEvent(String openId, LocalWechatMenu menu) throws IOException;

    WechatCommonResult pushNewsMessage(String openId, List<WechatCustomMessage.News.Article> articleList) throws IOException;

    WechatCommonResult pushTextMessage(String openId, String content) throws IOException;

    WechatCommonResult pushImageMessage(String openId, String mediaId) throws IOException;

    void pushMessageByMessage(String openId, Message message) throws IOException;

    void pushMessageListByMessage(String openId, List<Message> message) throws IOException;

    void pushSubscribeMessage(String openid) throws IOException;

    void pushChannelsMessage(String openId, String qrCodeScene) throws IOException;

}
