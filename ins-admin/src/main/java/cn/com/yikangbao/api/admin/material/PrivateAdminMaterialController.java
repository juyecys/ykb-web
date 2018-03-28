package cn.com.yikangbao.api.admin.material;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.wechat.material.WechatMaterial;
import cn.com.yikangbao.service.wechat.material.WechatMaterialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by jeysine on 2018/3/27.
 */
@RestController
@RequestMapping(value = { "/ykb/mg/private/material","/ykb/mg/public/material" }, produces = "application/json")
public class PrivateAdminMaterialController {
    @Autowired
    private WechatMaterialService wechatMaterialService;

    private static Logger logger = LoggerFactory.getLogger(PrivateAdminMaterialController.class);

    @RequestMapping(value = "/", method = RequestMethod.POST,  produces = "application/json")
    public ResponseEntity<ApiResult> material(@RequestParam("file") MultipartFile file, @RequestParam("type") String type) throws IOException {
        WechatMaterial wechatMaterial = wechatMaterialService.createForeverMaterial(file, type);
        logger.info("wechat material: {}", wechatMaterial);
        return new ResponseEntity<>(ApiResult.success(wechatMaterial), HttpStatus.OK);
    }
}