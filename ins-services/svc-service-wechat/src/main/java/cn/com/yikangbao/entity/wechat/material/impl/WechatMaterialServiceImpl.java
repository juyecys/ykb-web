package cn.com.yikangbao.entity.wechat.material.impl;

import cn.com.yikangbao.contants.wechat.WechatConfigParams;
import cn.com.yikangbao.entity.wechat.material.WechatMaterial;
import cn.com.yikangbao.service.wechat.accesstoken.WechatAccessTokenService;
import cn.com.yikangbao.service.wechat.material.WechatMaterialService;
import cn.com.yikangbao.untils.common.okhttputil.OkHttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by jeysine on 2018/2/9.
 */
@Service("wechatMaterialService")
public class WechatMaterialServiceImpl implements WechatMaterialService {
    @Autowired
    private WechatAccessTokenService wechatAccessTokenService;

    private Logger logger = LoggerFactory.getLogger(WechatMaterialServiceImpl.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public WechatMaterial createForeverMaterial(WechatMaterial wechatMaterial) throws IOException {
        String url = WechatConfigParams.WECHAT_ADD_MATERIAL.replace("ACCESS_TOKEN", wechatAccessTokenService.getAccessToken().getAccessToken())
                .replace("TYPE", wechatMaterial.getType());

        String result = OkHttpUtils.post().url(url).addFile("media",wechatMaterial.getMedia().getName(), wechatMaterial.getMedia()).build().execute().body().string();
        logger.info("create forever material result: {}", result);
        return mapper.readValue(result, WechatMaterial.class);
    }
}
