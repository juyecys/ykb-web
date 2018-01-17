package cn.com.yikangbao.service.roleresource.impl;

import cn.com.yikangbao.dao.roleresource.RoleResourceDAO;
import cn.com.yikangbao.entity.roleresource.RoleResource;
import cn.com.yikangbao.service.roleresource.RoleResourceService;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/1/18.
 */
@Service("roleResourceService")
public class RoleResourceServiceImpl extends BaseServiceImpl<RoleResource, RoleResource> implements RoleResourceService {
    @Autowired
    private RoleResourceDAO dao;

    @Autowired
    private void setDao(RoleResourceDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }

}
