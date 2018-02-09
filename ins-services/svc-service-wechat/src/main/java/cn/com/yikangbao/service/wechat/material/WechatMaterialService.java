package cn.com.yikangbao.service.wechat.material;

import cn.com.yikangbao.entity.wechat.material.WechatMaterial;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jeysine on 2018/2/9.
 */
public interface WechatMaterialService {
    WechatMaterial createForeverMaterial(WechatMaterial wechatMaterial) throws IOException;
}
