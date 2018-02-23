package cn.com.yikangbao.api.admin.wechatuser;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.common.Page;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUserDTO;
import cn.com.yikangbao.service.wechatuser.LocalWechatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = { "/ykb/mg/private/user","/ykb/mg/public/user" }, produces = "application/json")
public class PrivateAdminWechatUserController {
    @Autowired
    private LocalWechatUserService localWechatUserService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getUser(LocalWechatUserDTO wechatUser) {
        List<LocalWechatUserDTO> wechatUserList =  localWechatUserService.findByCondition(wechatUser);
        return new ResponseEntity<>(ApiResult.success(wechatUserList), HttpStatus.OK);
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getUserPage(LocalWechatUserDTO wechatUser) {
        Page<LocalWechatUserDTO> wechatUserList =  localWechatUserService.findByConditionPage(wechatUser);
        return new ResponseEntity<>(ApiResult.success(wechatUserList), HttpStatus.OK);
    }
}
