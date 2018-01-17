package cn.com.yikangbao.service.userrole;

import cn.com.yikangbao.entity.userrole.UserRoleDTO;
import cn.com.yikangbao.entity.common.PageResult;

import java.util.List;

/**
 * Created by jeysine on 2018/1/18.
 */
public interface UserRoleService {
    List<UserRoleDTO> findRolesByUserId(String userId);

    PageResult<UserRoleDTO> findAllByPage();
}
