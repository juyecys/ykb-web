package cn.com.yikangbao.api.wp.config;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.wechat.jssign.WechatJsSign;
import cn.com.yikangbao.service.wechat.jssign.WechatJsSignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jeysine on 2018/3/26.
 */
@RestController
@RequestMapping(value = { "/ykb/wp/public/config","/ykb/wp/private/config" }, produces = "application/json")
public class PublicWPConfigController {
    private static Logger logger = LoggerFactory.getLogger(PublicWPConfigController.class);

    @Autowired
    private WechatJsSignService wechatJsSignService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getConfig(@RequestParam("url") String url) throws Exception {
        WechatJsSign sign = wechatJsSignService.signUrl(url);
        return new ResponseEntity<>(ApiResult.success(sign), HttpStatus.OK);
    }

}
