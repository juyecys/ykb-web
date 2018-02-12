package cn.com.yikangbao.event.listener.wechat;

import cn.com.yikangbao.contants.wechat.WechatConfigParams;
import cn.com.yikangbao.entity.common.Event;
import cn.com.yikangbao.entity.message.Message;
import cn.com.yikangbao.entity.wechat.qrcode.LocalWechatQRCode;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUserDTO;
import cn.com.yikangbao.listener.EventListener;
import cn.com.yikangbao.service.message.MessageService;
import cn.com.yikangbao.service.wechat.qrcode.LocalWechatQRCodeService;
import cn.com.yikangbao.service.wechatuser.LocalWechatUserService;
import cn.com.yikangbao.untils.common.DateUtils;
import cn.com.yikangbao.untils.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jeysine on 2018/2/8.
 */
@Component
public class WechatUserSubscribeEventListener implements EventListener{

    private Logger logger = LoggerFactory.getLogger(WechatUserSubscribeEventListener.class);

    @Autowired
    private LocalWechatUserService localWechatUserService;

    @Autowired
    private LocalWechatQRCodeService localWechatQRCodeService;

    @Autowired
    private MessageService messageService;

    @Override
    public String getId() {
        return "YKB_EVENT_WECHAT_USER_SUBSCRIBE_EVENT";
    }

    @Override
    public void handleEvent(Event event) {
        logger.debug("处理关注事件: {}",event);
        Map<String, Object> properties = event.getProperties();
        String openId = properties.get("openId").toString();
        Date createdTime = DateUtils.toDate((Long) properties.get("createTime"));
        String eventKey = properties.get("eventKey") == null ? null: properties.get("eventKey").toString();

        LocalWechatUserDTO old = createOrUpdateWechatUser(openId, createdTime);

        if (!(StringUtil.isEmpty(eventKey) && StringUtil.isEmpty(old.getQrCodeScene()))) {
            eventKey = eventKey.replace(WechatConfigParams.WECHAT_PREFIX_QRCODE_EVENT_KEY, "");
            LocalWechatQRCode qrCode = new LocalWechatQRCode();
            qrCode.setScene(eventKey);
            qrCode = localWechatQRCodeService.findOneByCondition(qrCode);
            if (qrCode == null) {
                logger.error("not find this channel qrcode, scene: {}", eventKey);
            }
            qrCode.setScanTime(qrCode.getScanTime() + 1);
            localWechatQRCodeService.update(qrCode);
            try {
                if (qrCode.getSendSubscribeMessage()) {
                    messageService.pushSubscribeMessage(openId);
                }
                if (qrCode.getSendChannelMessage()) {
                    messageService.pushChannelsMessage(openId, eventKey);
                }
            }catch (IOException e) {
                logger.error("error: {}",e);
            }
        }

        if (StringUtil.isEmpty(eventKey)) {
            try {
                messageService.pushSubscribeMessage(openId);
            }catch (IOException e) {
                logger.error("error: {}",e);
            }
        }

    }

    private LocalWechatUserDTO createOrUpdateWechatUser(String openId, Date createdTime) {
        LocalWechatUserDTO user = new LocalWechatUserDTO();
        user.setOpenId(openId);
        LocalWechatUserDTO old = localWechatUserService.findOneByCondition(user);

        user.setCreatedDate(createdTime);

        if (old == null) {
            localWechatUserService.create(user);
        } else {
            old.setCreatedDate(createdTime);
            old.setUpdatedDate(new Date());
            localWechatUserService.update(old);
        }
        return old;
    }
}
