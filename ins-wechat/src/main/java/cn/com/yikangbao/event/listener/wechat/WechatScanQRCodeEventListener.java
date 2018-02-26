package cn.com.yikangbao.event.listener.wechat;

import cn.com.yikangbao.entity.channel.ChannelDTO;
import cn.com.yikangbao.entity.common.Event;
import cn.com.yikangbao.listener.EventListener;
import cn.com.yikangbao.service.channel.ChannelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by jeysine on 2018/2/12.
 */
@Component
public class WechatScanQRCodeEventListener  implements EventListener {
    private Logger logger = LoggerFactory.getLogger(WechatScanQRCodeEventListener.class);
    @Autowired
    private ChannelService channelService;

    @Override
    public String getId() {
        return "YKB_EVENT_WECHAT_SCAN_QRCODE_EVENT";
    }

    @Override
    public void handleEvent(Event event){
        logger.debug("处理扫码事件: {}",event);
        Map<String, Object> properties = event.getProperties();
        ChannelDTO channel = new ChannelDTO();
        channel.setScene(properties.get("eventKey").toString());
        channel = channelService.findOneByCondition(channel);
        if (channel == null) {
            logger.error("not find this channel qrcode, scene: {}", properties.get("eventKey").toString());
        }
        channel.setScanTime(channel.getScanTime() + 1);
        channelService.update(channel);
    }
}
