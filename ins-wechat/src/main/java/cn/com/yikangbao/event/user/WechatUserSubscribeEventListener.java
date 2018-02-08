package cn.com.yikangbao.event.user;

import cn.com.yikangbao.entity.wechatuser.LocalWechatUser;
import cn.com.yikangbao.event.Event;
import cn.com.yikangbao.listener.EventListener;
import cn.com.yikangbao.service.wechatuser.LocalWechatUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by jeysine on 2018/2/8.
 */
@Component
public class WechatUserSubscribeEventListener implements EventListener{

    private Logger logger = LoggerFactory.getLogger(WechatUserSubscribeEventListener.class);

    @Autowired
    private LocalWechatUserService localWechatUserService;

    @Override
    public String getId() {
        return "YKB_EVENT_WECHAT_USER_SUBSCRIBE_EVENT";
    }

    @Override
    public void handleEvent(Event event) {
        Map<String, Object> properties = event.getProperties();

    }
}
