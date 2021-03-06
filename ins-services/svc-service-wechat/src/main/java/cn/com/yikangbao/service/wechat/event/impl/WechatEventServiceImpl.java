package cn.com.yikangbao.service.wechat.event.impl;

import cn.com.yikangbao.contants.wechat.WechatEventConstant;
import cn.com.yikangbao.entity.common.Event;
import cn.com.yikangbao.entity.wechat.event.WechatBaseEvent;
import cn.com.yikangbao.entity.wechat.event.WechatMenuClickEvent;
import cn.com.yikangbao.entity.wechat.event.WechatScanEvent;
import cn.com.yikangbao.entity.wechat.event.WechatSubscribeEvent;
import cn.com.yikangbao.entity.wechat.localwechatmenu.LocalWechatMenu;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUserDTO;
import cn.com.yikangbao.service.event.EventService;
import cn.com.yikangbao.service.event.EventServiceException;
import cn.com.yikangbao.service.wechat.event.WechatEventService;
import cn.com.yikangbao.service.wechat.localMenu.LocalWechatMenuService;
import cn.com.yikangbao.service.wechat.message.WechatMessageService;
import cn.com.yikangbao.service.wechatuser.LocalWechatUserService;
import cn.com.yikangbao.untils.common.MapUtils;
import cn.com.yikangbao.untils.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by jeysine on 2018/1/24.
 */
@Service("wechatEventService")
public class WechatEventServiceImpl implements WechatEventService {

    @Autowired
    private LocalWechatMenuService localWechatMenuService;

    @Autowired
    private WechatMessageService wechatMessageService;

    @Autowired
    private LocalWechatUserService localWechatUserService;

    @Autowired
    private EventService eventService;

    private Logger logger = LoggerFactory.getLogger(WechatEventServiceImpl.class);

    @Override
    public void processEvent(HashMap<String, Object> data) throws Exception {
        String event = (String) data.get("Event");
        logger.debug("处理微信事件 data: {}",data);
        if (WechatBaseEvent.EventEnum.SUBSCRIBE.getValue().equals(event)) {
            WechatSubscribeEvent subscribeEvent = (WechatSubscribeEvent) MapUtils.getObject(data, WechatSubscribeEvent.class, MapUtils.FirstOneCaseEnum.UPPER);
            processSubscribeEvent(subscribeEvent);
        } else if (WechatBaseEvent.EventEnum.UN_SUBSCRIBE.getValue().equals(event)) {
            WechatSubscribeEvent unsubscribeEvent = (WechatSubscribeEvent) MapUtils.getObject(data, WechatSubscribeEvent.class, MapUtils.FirstOneCaseEnum.UPPER);
            processUnSubscribeEvent(unsubscribeEvent);
        } else if (WechatBaseEvent.EventEnum.SCAN.getValue().equals(event)) {
            WechatScanEvent scanEvent = (WechatScanEvent) MapUtils.getObject(data, WechatScanEvent.class, MapUtils.FirstOneCaseEnum.UPPER);
            processScanEvent(scanEvent);
        } else if (WechatBaseEvent.EventEnum.CLICK.getValue().equals(event)) {
            WechatMenuClickEvent menuClickEvent = (WechatMenuClickEvent) MapUtils.getObject(data, WechatMenuClickEvent.class, MapUtils.FirstOneCaseEnum.UPPER);
            processMenuClickEvent(menuClickEvent);
        }

    }

    @Override
    public void processSubscribeEvent(WechatSubscribeEvent subscribeEvent) throws IOException, EventServiceException {
        logger.debug("发布关注事件 subscribeEvent: {}",subscribeEvent);
        Event event = new Event();
        event.addProperty("openId", subscribeEvent.getFromUserName());
        event.addProperty("createTime", subscribeEvent.getCreateTime());
        if (!StringUtil.isEmpty(subscribeEvent.getEventKey())) {
            event.addProperty("eventKey", subscribeEvent.getEventKey());
        }
        event.setType(WechatEventConstant.EVENT_TYPE_WECHAT_USER_SUBSCRIBE);
        eventService.publish(event);

    }

    private LocalWechatUserDTO createOrUpdateWechatUser(String openId, Date createdTime) {
        LocalWechatUserDTO user = new LocalWechatUserDTO();
        user.setOpenId(openId);
        LocalWechatUserDTO old = localWechatUserService.findOneByCondition(user);

        if (old == null) {
            user.setCreatedDate(createdTime);
            user.setSubscribeTime(createdTime);
            localWechatUserService.create(user);
        } else {
            old.setUpdatedDate(new Date());
            localWechatUserService.update(old);
        }
        return old;
    }

    @Override
    public void processUnSubscribeEvent(WechatSubscribeEvent unsubscribeEvent) {

    }

    @Override
    public void processScanEvent(WechatScanEvent scanEvent) throws Exception {
        logger.debug("处理扫描二维码事件 scanEvent: {}",scanEvent);

        /*Event event = new Event();
        event.addProperty("eventKey", scanEvent.getEventKey());
        event.addProperty("openId", scanEvent.getFromUserName());
        event.setType(WechatEventConstant.EVENT_TYPE_WECHAT_SCAN_QR_CODE);
        eventService.publish(event);*/
    }

    @Override
    public void processMenuClickEvent(WechatMenuClickEvent menuEvent) throws Exception {
        logger.debug("处理菜单点击事件 scanEvent: {}",menuEvent);
        LocalWechatMenu menu = new LocalWechatMenu();
        menu.setKey(menuEvent.getEventKey());

        menu = localWechatMenuService.findOneByCondition(menu);

        if (menu == null) {
            logger.warn("not found this wechat menu key: {}", menuEvent.getEventKey());
            throw new Exception("not found this wechat menu");
        }

        switch (menu.getType()) {
            case "article":
                wechatMessageService.pushNewsMessageByMenuEvent(menuEvent.getFromUserName(), menu);
                break;
            case "text":
                wechatMessageService.pushTextMessageByMenuEvent(menuEvent.getFromUserName(), menu);
                break;
        }
    }

    public static void main(String[] args) {


    }
}
