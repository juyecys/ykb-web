package cn.com.yikangbao.api.admin.login;

import cn.com.yikangbao.api.common.ApiCodes;
import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.ContextHolder;
import cn.com.yikangbao.entity.user.User;
import cn.com.yikangbao.service.user.UserService;
import cn.com.yikangbao.utils.common.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/1/16.
 */

@RestController
@RequestMapping(value = { "/ykb/mg/public/user" }, produces = "application/json")
public class PublicUserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> login(@RequestBody User user, HttpServletRequest request) {
        String password = user.getPassword();
        if (password == null || user.getName() == null) {
            return new ResponseEntity<>(ApiResult.error(ApiCodes.STATUS_INVALID_PARAMETER, "用户名或者密码不能为空"), HttpStatus.OK);
        }
        user = userService.findOneByCondition(user);
        if (user == null) {
            return new ResponseEntity<>(ApiResult.error(ApiCodes.STATUS_NOT_FOUND, "不存在该用户"), HttpStatus.OK);
        }
        String md5Password = MD5Util.MD5Encode(password, "UTF-8").toLowerCase();
        if (md5Password.equals(user.getPassword())) {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getName(), password);
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            HttpSession session = request.getSession();
            session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
            ContextHolder.setUser(user);
            return new ResponseEntity<>(ApiResult.success(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ApiResult.error(ApiCodes.STATUS_WRONG_OLD_PASSWORD, "密码错误"), HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> test(User user, HttpServletRequest request) {

        return new ResponseEntity<>(ApiResult.success(), HttpStatus.OK);
    }

}
