package cn.com.yikangbao.api.admin.auithority;

import cn.com.yikangbao.entitys.authority.User;
import cn.com.yikangbao.service.authority.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * Created by Administrator on 2018/1/16.
 */

@RestController
@RequestMapping(value = { "/test" }, produces = "application/json")
public class TestController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<User> test(HttpServletRequest request) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setAge(27);
        user.setName("jeysine");
        user = userService.create(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
