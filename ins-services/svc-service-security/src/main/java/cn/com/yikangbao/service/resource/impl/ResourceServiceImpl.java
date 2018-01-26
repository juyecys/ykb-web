package cn.com.yikangbao.service.resource.impl;

import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.yikangbao.dao.resource.ResourceDAO;
import cn.com.yikangbao.entity.resource.Resource;
import cn.com.yikangbao.service.resource.ResourceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("resourceService")
public class ResourceServiceImpl extends BaseServiceImpl<Resource, Resource> implements ResourceService {

    @Autowired
    private ResourceDAO dao;

    @Autowired
    private void setDao(ResourceDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }

    @Override
    public List<Resource> findResourceByRoleName(String name) {
        return dao.findResourceByRoleName(name);
    }

}
