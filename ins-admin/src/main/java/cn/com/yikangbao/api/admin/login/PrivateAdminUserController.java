package cn.com.yikangbao.api.admin.login;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.user.User;
import cn.com.yikangbao.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/1/16.
 */

@RestController
@RequestMapping(value = { "/ykb/mg/private/user" }, produces = "application/json")
public class PrivateAdminUserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> test(User user, HttpServletRequest request) {

        return new ResponseEntity<>(ApiResult.success(), HttpStatus.OK);
    }
}
