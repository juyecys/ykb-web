package cn.com.yikangbao.service.wechat.event.impl;

import cn.com.yikangbao.contants.wechat.WechatConfigParams;
import cn.com.yikangbao.entity.wechat.event.WechatBaseEvent;
import cn.com.yikangbao.entity.wechat.event.WechatMenuClickEvent;
import cn.com.yikangbao.entity.wechat.event.WechatScanEvent;
import cn.com.yikangbao.entity.wechat.event.WechatSubscribeEvent;
import cn.com.yikangbao.entity.wechat.localwechatmenu.LocalWechatMenu;
import cn.com.yikangbao.entity.wechat.message.WechatCustomMessage;
import cn.com.yikangbao.entity.wechat.qrcode.LocalWechatQRCode;
import cn.com.yikangbao.entity.wechat.result.WechatCommonResult;
import cn.com.yikangbao.entity.wechatuser.WechatUser;
import cn.com.yikangbao.entity.wechatuser.WechatUserDTO;
import cn.com.yikangbao.service.wechat.event.WechatEventService;
import cn.com.yikangbao.service.wechat.localMenu.LocalWechatMenuService;
import cn.com.yikangbao.service.wechat.message.WechatMessageService;
import cn.com.yikangbao.service.wechat.qrcode.LocalWechatQRCodeService;
import cn.com.yikangbao.service.wechatuser.WechatUserService;
import cn.com.yikangbao.untils.common.DateUtils;
import cn.com.yikangbao.untils.common.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by jeysine on 2018/1/24.
 */
@Service("wechatEventService")
public class WechatEventServiceImpl implements WechatEventService {

    @Autowired
    private WechatUserService wechatUserService;

    @Autowired
    private LocalWechatQRCodeService localWechatQRCodeService;

    @Autowired
    private LocalWechatMenuService localWechatMenuService;

    @Autowired
    private WechatMessageService wechatMessageService;

    private Logger logger = LoggerFactory.getLogger(WechatEventServiceImpl.class);

    @Override
    public void processEvent(HashMap<String, String> data) throws Exception {
        String event = data.get("Event");
        logger.debug("处理微信事件 data: {}",data);
        if (WechatBaseEvent.EventEnum.SUBSCRIBE.getValue().equals(event)) {
            WechatSubscribeEvent subscribeEvent = (WechatSubscribeEvent) MapUtils.getObject(data, WechatSubscribeEvent.class);
            processSubscribeEvent(subscribeEvent);
        } else if (WechatBaseEvent.EventEnum.UN_SUBSCRIBE.getValue().equals(event)) {
            WechatSubscribeEvent unsubscribeEvent = (WechatSubscribeEvent) MapUtils.getObject(data, WechatSubscribeEvent.class);
            processUnSubscribeEvent(unsubscribeEvent);
        } else if (WechatBaseEvent.EventEnum.SCAN.getValue().equals(event)) {
            WechatScanEvent scanEvent = (WechatScanEvent) MapUtils.getObject(data, WechatScanEvent.class);
            processScanEvent(scanEvent);
        } else if (WechatBaseEvent.EventEnum.CLICK.getValue().equals(event)) {
            WechatMenuClickEvent menuClickEvent = (WechatMenuClickEvent) MapUtils.getObject(data, WechatMenuClickEvent.class);
            processMenuClickEvent(menuClickEvent);
        }

    }

    @Override
    public void processSubscribeEvent(WechatSubscribeEvent subscribeEvent) throws IOException {
        logger.debug("处理关注用户数据 subscribeEvent: {}",subscribeEvent);

        WechatUserDTO user = new WechatUserDTO();
        user.setOpenId(subscribeEvent.getFromUserName());
        WechatUser old = wechatUserService.findOneByCondition(user);

        user.setCreatedDate(DateUtils.toDate(subscribeEvent.getCreateTime()));
        if (subscribeEvent.getEventKey() != null) {
            user.setQrCodeScene(subscribeEvent.getEventKey().replace(WechatConfigParams.WECHAT_PREFIX_QRCODE_EVENT_KEY, ""));
        }

        if (old == null) {
            wechatUserService.create(user);
        } else {
            old.setCreatedDate(DateUtils.toDate(subscribeEvent.getCreateTime()));
            wechatUserService.update(old);
        }
        wechatMessageService.pushTextMessage(user.getOpenId(), WechatConfigParams.WECHAT_SUBSCRIBE_REPLY);
        wechatMessageService.pushImageMessage(user.getOpenId(), WechatConfigParams.WECHAT_SUBSCRIBE_REPLY_QRCODE_MEDIA_ID);
    }

    @Override
    public void processUnSubscribeEvent(WechatSubscribeEvent unsubscribeEvent) {

    }

    @Override
    public void processScanEvent(WechatScanEvent scanEvent) throws Exception {
        logger.debug("处理扫描二维码事件 scanEvent: {}",scanEvent);
        LocalWechatQRCode qrCode = new LocalWechatQRCode();
        qrCode.setScene(scanEvent.getEventKey());
        qrCode = localWechatQRCodeService.findOneByCondition(qrCode);
        if (qrCode == null) {
            logger.warn("not find this channel qrcode, scene: {}", scanEvent.getEventKey());
            throw new Exception("not find this channel qrcode, scene");
        }
        qrCode.setScanTime(qrCode.getScanTime() + 1);
        localWechatQRCodeService.update(qrCode);
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
        WechatCommonResult result;

        switch (menu.getType()) {
            case "article":
                result = wechatMessageService.pushNewsMessageByMenuEvent(menuEvent.getFromUserName(), menu);
                break;
            case "text":
                result = wechatMessageService.pushTextMessageByMenuEvent(menuEvent.getFromUserName(), menu);
                break;
        }

    }
}
