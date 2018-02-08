package cn.com.yikangbao.service.wechat.auth.impl;

import cn.com.yikangbao.config.wechat.WechatConfigSecret;
import cn.com.yikangbao.contants.wechat.WechatConfigParams;
import cn.com.yikangbao.entity.wechat.auth.WechatAuthAccessToken;
import cn.com.yikangbao.service.wechat.auth.WechatAuthService;
import cn.com.yikangbao.untils.common.okhttputil.OkHttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by jeysine on 2018/2/8.
 */
@Service("wechatAuthService")
public class WechatAuthServiceImpl implements WechatAuthService {

    private static Logger logger = LoggerFactory.getLogger(WechatAuthServiceImpl.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    private WechatAuthAccessToken getAuthAccessToken(String url) throws IOException {
        Response response = OkHttpUtils.get().url(url)
                .build().execute();
        String result = response.body().string();
        logger.info("get auth access token result: {}", result);
        return mapper.readValue(result, WechatAuthAccessToken.class);
    }

    @Override
    public WechatAuthAccessToken getAuthAccessTokenByCode(String code) throws IOException {
        String url = WechatConfigParams.WECHAT_GET_AUTH_ACCESSTOKEN_URL.replace("APPID", WechatConfigSecret.getWechatAppid())
                .replace("APPSECRET", WechatConfigSecret.getWechatSecret()).replace("CODE", code);
        return getAuthAccessToken(url);
    }

    @Override
    public WechatAuthAccessToken getAccessTokenByRefreshToken(String refreshToken) throws IOException {
        String url = WechatConfigParams.WECHAT_REFRESH_AUTH_ACCESSTOKEN_URL.replace("APPID", WechatConfigSecret.getWechatAppid())
                .replace("REFRESH_TOKEN", refreshToken);
        return getAuthAccessToken(url);
    }
}
