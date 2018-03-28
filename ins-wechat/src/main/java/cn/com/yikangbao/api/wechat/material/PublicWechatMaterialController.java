package cn.com.yikangbao.api.wechat.material;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.wechat.material.WechatMaterial;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUserDTO;
import cn.com.yikangbao.service.wechat.event.WechatEventService;
import cn.com.yikangbao.service.wechat.material.WechatMaterialService;
import cn.com.yikangbao.service.wechatuser.LocalWechatUserService;
import cn.com.yikangbao.untils.common.Dom4jUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.dom4j.DocumentException;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping(value = { "/ykb/wechat/public/material" })
public class PublicWechatMaterialController {

    @Autowired
    private WechatMaterialService wechatMaterialService;

    @Autowired
    private LocalWechatUserService localWechatUserService;

    private static Logger logger = LoggerFactory.getLogger(PublicWechatMaterialController.class);

    @RequestMapping(value = "/", method = RequestMethod.POST,  produces = "application/json")
    public ResponseEntity<ApiResult> test(@RequestParam("file") MultipartFile file, @RequestParam("type") String type) throws IOException {
        WechatMaterial wechatMaterial = wechatMaterialService.createForeverMaterial(file, type);
        logger.info("wechat material: {}", wechatMaterial);
        return new ResponseEntity<>(ApiResult.success(wechatMaterial), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET,  produces = "application/json")
    public ResponseEntity<ApiResult> test() throws IOException {

        List<LocalWechatUserDTO> list = localWechatUserService.findByCondition(new LocalWechatUserDTO());
        logger.info("wechat material: {}", list);
        return new ResponseEntity<>(ApiResult.success(list), HttpStatus.OK);
    }


}
