package cn.com.yikangbao.api.admin.authority;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.role.Role;
import cn.com.yikangbao.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jeysine on 2018/1/22.
 */
@RestController
@RequestMapping(value = "/ykb/mg/private/role", produces = "application/json")
public class PrivateRoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> addRole(@RequestBody Role role) {
        role.setCode(Role.RoleCodeEnum.ROLE_ADMIN.name());
        roleService.create(role);
        return new ResponseEntity<>(ApiResult.success(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getRoleList(Role role) {
        List<Role> roleList = roleService.findAll();
        return new ResponseEntity<>(ApiResult.success(roleList), HttpStatus.OK);
    }
}
