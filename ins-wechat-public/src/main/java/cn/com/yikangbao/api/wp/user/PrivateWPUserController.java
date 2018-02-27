package cn.com.yikangbao.api.wp.user;

import cn.com.yikangbao.api.common.ApiCodes;
import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.config.common.WechatContextHolder;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUserDTO;
import cn.com.yikangbao.service.wechatuser.LocalWechatUserService;
import cn.com.yikangbao.untils.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jeysine on 2018/2/27.
 */
@RestController
@RequestMapping(value = { "/ykb/wp/private/user"}, produces = "application/json")
public class PrivateWPUserController {

    @Autowired
    private LocalWechatUserService localWechatUserService;

    @RequestMapping(value = "/one", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getUser() {
        String openId = WechatContextHolder.getOpenId();
        if (!StringUtil.isEmpty(openId)) {
            LocalWechatUserDTO wechatUser = new LocalWechatUserDTO();
            wechatUser.setOpenId(openId);
            wechatUser = localWechatUserService.findOneByCondition(wechatUser);
            return new ResponseEntity<>(ApiResult.success(wechatUser), HttpStatus.OK);
        }
        return new ResponseEntity<>(ApiResult.build(ApiCodes.STATUS_UNKNOWN_USER_ERROR, "未知用户"), HttpStatus.OK);
    }
}
