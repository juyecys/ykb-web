package cn.com.yikangbao.service.role.impl;

import cn.com.yikangbao.dao.role.RoleDAO;
import cn.com.yikangbao.entity.role.Role;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.yikangbao.service.role.RoleService;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role, Role> implements RoleService {
    @Autowired
    private RoleDAO dao;

    @Autowired
    private void setDao(RoleDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }
}
