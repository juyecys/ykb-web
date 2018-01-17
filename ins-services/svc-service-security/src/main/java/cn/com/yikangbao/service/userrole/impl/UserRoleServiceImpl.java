package cn.com.yikangbao.service.userrole.impl;

import cn.com.yikangbao.dao.userrole.UserRoleDAO;
import cn.com.yikangbao.entity.userrole.UserRole;
import cn.com.yikangbao.entity.userrole.UserRoleDTO;
import cn.com.yikangbao.entity.common.PageResult;
import cn.com.yikangbao.service.userrole.UserRoleService;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/1/18.
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole, UserRoleDTO> implements UserRoleService {
    private UserRoleDAO dao;

    @Autowired
    private void setDao(UserRoleDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }

    @Override
    public List<UserRoleDTO> findRolesByUserId(String userId) {
        return dao.findRolesByUserId(userId);
    }

    @Override
    public PageResult<UserRoleDTO> findAllByPage() {
        return null;
    }
}
