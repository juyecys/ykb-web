package cn.com.yikangbao.api.admin.authority;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.roleresource.RoleResource;
import cn.com.yikangbao.service.roleresource.RoleResourceService;
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
@RequestMapping(value = "/ykb/mg/private/authority", produces = "application/json")
public class PrivateAdminAuthorityController {
    @Autowired
    private RoleResourceService roleResourceService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> authority(@RequestBody RoleResource roleResource) throws Exception {
        roleResource = roleResourceService.createOrUpdate(roleResource);
        return new ResponseEntity<>(ApiResult.success(roleResource), HttpStatus.OK);
    }
}
