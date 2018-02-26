package cn.com.yikangbao.event.listener.wechat;

import cn.com.yikangbao.contants.wechat.WechatConfigParams;
import cn.com.yikangbao.contants.wechat.WechatEventConstant;
import cn.com.yikangbao.entity.channel.ChannelDTO;
import cn.com.yikangbao.entity.common.Event;
import cn.com.yikangbao.entity.wechat.event.WechatSubscribeEvent;
import cn.com.yikangbao.entity.wechat.user.WechatUser;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUserDTO;
import cn.com.yikangbao.listener.EventListener;
import cn.com.yikangbao.service.channel.ChannelService;
import cn.com.yikangbao.service.wechat.message.WechatMessageService;
import cn.com.yikangbao.service.wechat.user.WechatUserService;
import cn.com.yikangbao.service.wechatuser.LocalWechatUserService;
import cn.com.yikangbao.untils.common.DateUtils;
import cn.com.yikangbao.untils.common.MapUtils;
import cn.com.yikangbao.untils.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
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
    private ChannelService channelService;

    @Autowired
    private WechatMessageService wechatMessageService;

    @Autowired
    private WechatUserService wechatUserService;

    @Override
    public String getId() {
        return "YKB_EVENT_WECHAT_USER_SUBSCRIBE_EVENT";
    }

    @Override
    public void handleEvent(Event event) {
        logger.debug("处理关注事件: {}",event);
        Map<String, Object> properties = event.getProperties();
        String openId = properties.get("openId").toString();
        Date createdTime = DateUtils.toDate(((Integer)properties.get("createTime")).longValue());
        String eventKey = properties.get("eventKey") == null ? null: properties.get("eventKey").toString();

        LocalWechatUserDTO old = null;
        try {
            if (!StringUtil.isEmpty(eventKey)) {
                eventKey = eventKey.replace(WechatConfigParams.WECHAT_PREFIX_QRCODE_EVENT_KEY, "");
            }
            old = createOrUpdateWechatUser(openId, createdTime, eventKey);
            if (!StringUtil.isEmpty(eventKey) && !StringUtil.isEmpty(old.getQrCodeScene())) {
                ChannelDTO channel = new ChannelDTO();
                channel.setScene(eventKey);
                channel = channelService.findOneByCondition(channel);
                if (channel == null) {
                    logger.error("not find this channel qrcode, scene: {}", eventKey);
                }
                channel.setScanTime(channel.getScanTime() + 1);
                channelService.update(channel);

                if (channel.getSendSubscribeMessage()) {
                    wechatMessageService.pushSubscribeMessage(openId);
                }
                if (channel.getSendChannelMessage()) {
                    wechatMessageService.pushChannelsMessage(openId, eventKey);
                }
            }
            if (StringUtil.isEmpty(eventKey)) {
                wechatMessageService.pushSubscribeMessage(openId);

            }
        } catch (IOException e) {
            logger.error("error: {}",e);
        }
    }

    private LocalWechatUserDTO createOrUpdateWechatUser(String openId, Date createdTime, String qrCodeScene) throws IOException {
        LocalWechatUserDTO user = new LocalWechatUserDTO();
        user.setOpenId(openId);
        LocalWechatUserDTO old = localWechatUserService.findOneByCondition(user);

        if (old == null) {
            WechatUser wechatUser = wechatUserService.getWechatUserInfo(openId, null);
            user.setCity(wechatUser.getCity());
            user.setCountry(wechatUser.getCountry());
            user.setHeadImgUrl(wechatUser.getHeadImgUrl());
            user.setNickName(wechatUser.getNickname());
            user.setProvince(wechatUser.getProvince());
            user.setRemark(wechatUser.getRemark());
            user.setGender(wechatUser.getSex());
            user.setSubscribe(wechatUser.getSubscribe());
            user.setUnionId(wechatUser.getUnionId());
            user.setOpenId(wechatUser.getOpenId());
            user.setQrCodeScene(qrCodeScene);
            user.setCreatedDate(createdTime);
            user.setSubscribeTime(createdTime);
            localWechatUserService.create(user);
        } else {
            old.setUpdatedDate(new Date());
            localWechatUserService.update(old);
        }
        return old;
    }

    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("CreateTime", "1519378340");
        map.put("Event", "subscribe");
        map.put("ToUserName", "gh_a1fc816c0c9a");
        map.put("FromUserName", "opqVDwrWpGfjwW0tTuqpk38rS-hc");
        map.put("MsgType", "event");
        try {
            WechatSubscribeEvent subscribeEvent = (WechatSubscribeEvent) MapUtils.getObject(map, WechatSubscribeEvent.class, MapUtils.FirstOneCaseEnum.UPPER);
            System.out.println(subscribeEvent);

            Event event = new Event();
            event.addProperty("openId", subscribeEvent.getFromUserName());
            event.addProperty("createTime", subscribeEvent.getCreateTime());
            event.addProperty("eventKey", subscribeEvent.getEventKey());
            event.setType(WechatEventConstant.EVENT_TYPE_WECHAT_USER_SUBSCRIBE);
            Map<String, Object> properties = event.getProperties();
            String eventKey = properties.get("eventKey") == null ? null: properties.get("eventKey").toString();

            System.out.println(StringUtil.isEmpty(eventKey));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
