package cn.com.yikangbao.service.wechat.material;

import cn.com.yikangbao.entity.wechat.material.WechatMaterial;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by jeysine on 2018/2/9.
 */
public interface WechatMaterialService {
    WechatMaterial createForeverMaterial(MultipartFile file, String type) throws IOException;
}
