package cn.com.yikangbao.event.listener.wechat;

import cn.com.yikangbao.contants.wechat.WechatConfigParams;
import cn.com.yikangbao.entity.channel.ChannelDTO;
import cn.com.yikangbao.entity.common.Event;
import cn.com.yikangbao.listener.EventListener;
import cn.com.yikangbao.service.channel.ChannelService;
import cn.com.yikangbao.service.wechat.message.WechatMessageService;
import cn.com.yikangbao.untils.common.DateUtils;
import cn.com.yikangbao.untils.common.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * Created by jeysine on 2018/2/12.
 */
@Component
public class WechatScanQRCodeEventListener  implements EventListener {
    private Logger logger = LoggerFactory.getLogger(WechatScanQRCodeEventListener.class);

    @Autowired
    private ChannelService channelService;

    @Autowired
    private WechatMessageService wechatMessageService;

    @Override
    public String getId() {
        return "YKB_EVENT_WECHAT_SCAN_QRCODE_EVENT";
    }

    @Override
    public void handleEvent(Event event){
        logger.debug("处理扫描二维码事件: {}",event);
        Map<String, Object> properties = event.getProperties();
        String openId = properties.get("openId").toString();
        String eventKey = properties.get("eventKey") == null ? null: properties.get("eventKey").toString();
    }
}
