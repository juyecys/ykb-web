package cn.com.yikangbao.service.wechat.material.impl;

import cn.com.yikangbao.contants.wechat.WechatConfigParams;
import cn.com.yikangbao.entity.wechat.material.WechatMaterial;
import cn.com.yikangbao.service.wechat.accesstoken.WechatAccessTokenService;
import cn.com.yikangbao.service.wechat.material.WechatMaterialService;
import cn.com.yikangbao.untils.common.okhttputil.OkHttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
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

    @Value("${ykb.temp.dir}")
    private String tempDir;

    @Override
    public WechatMaterial createForeverMaterial(MultipartFile multipartFile, String type) throws IOException {
        logger.debug("{}", multipartFile);
        File file = getFileFromMultipartFile(multipartFile);
        if (!file.exists()) {
            return null;
        }
        String url = WechatConfigParams.WECHAT_ADD_MATERIAL.replace("ACCESS_TOKEN", wechatAccessTokenService.getAccessToken().getAccessToken())
                .replace("TYPE", type);
        logger.info("create forever material url:{}", url);

        String result = OkHttpUtils.post().url(url).addFile("media",file.getName(), file).build().execute().body().string();
        logger.info("create forever material result: {}", result);
        return mapper.readValue(result, WechatMaterial.class);
    }

    private File getFileFromMultipartFile(MultipartFile multipartFile) throws IOException {
        File dir = new File(tempDir);
        if(!dir.exists()) {
            dir.mkdir();
        }
        String path = tempDir + multipartFile.getOriginalFilename();
        File file = new File(path);
        multipartFile.transferTo(file);
        return file;
    }

}
