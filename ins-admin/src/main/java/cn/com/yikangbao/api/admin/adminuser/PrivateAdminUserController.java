package cn.com.yikangbao.api.admin.adminuser;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.common.Page;
import cn.com.yikangbao.entity.user.User;
import cn.com.yikangbao.entity.user.UserDTO;
import cn.com.yikangbao.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jeysine on 2018/3/5.
 */
@RestController
@RequestMapping(value = "/ykb/mg/private/user", produces = "application/json")
public class PrivateAdminUserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> addUser(@RequestBody User user) throws Exception {
        user = userService.createOrUpdate(user);
        return new ResponseEntity<>(ApiResult.success(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> findPage(UserDTO user) throws Exception {
        Page<UserDTO> page = userService.findByConditionPage(user);
        return new ResponseEntity<>(ApiResult.success(page), HttpStatus.OK);
    }
}