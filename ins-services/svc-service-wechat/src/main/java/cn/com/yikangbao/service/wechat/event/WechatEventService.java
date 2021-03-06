package cn.com.yikangbao.service.wechat.event;

import cn.com.yikangbao.entity.wechat.event.WechatMenuClickEvent;
import cn.com.yikangbao.entity.wechat.event.WechatScanEvent;
import cn.com.yikangbao.entity.wechat.event.WechatSubscribeEvent;
import cn.com.yikangbao.service.event.EventServiceException;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by jeysine on 2018/1/24.
 */
public interface WechatEventService {
    void processEvent(HashMap<String, Object> data) throws Exception;

    void processSubscribeEvent(WechatSubscribeEvent subscribeEvent) throws IOException, EventServiceException;

    void processUnSubscribeEvent(WechatSubscribeEvent unsubscribeEvent);

    void processScanEvent(WechatScanEvent scanEvent) throws Exception;

    void processMenuClickEvent(WechatMenuClickEvent menuEvent) throws Exception;
}
