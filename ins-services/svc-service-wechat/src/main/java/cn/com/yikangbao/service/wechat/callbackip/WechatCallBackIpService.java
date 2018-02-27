package cn.com.yikangbao.service.wechat.callbackip;

import cn.com.yikangbao.entity.wechat.acesstoken.WechatAccessToken;
import cn.com.yikangbao.entity.wechat.callbackip.WechatCallBackIp;

import java.io.IOException;

/**
 * Created by jeysine on 2018/2/27.
 */
public interface WechatCallBackIpService {
    WechatCallBackIp getWechatCallBackIp(WechatAccessToken wechatAccessToken) throws IOException;
}
