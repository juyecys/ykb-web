package cn.com.yikangbao.service.menu.impl;

import cn.com.yikangbao.dao.menu.MenuDAO;
import cn.com.yikangbao.entity.menu.Menu;
import cn.com.yikangbao.entity.resource.Resource;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import cn.com.yikangbao.service.menu.MenuService;
import cn.com.yikangbao.service.resource.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jeysine on 2018/3/5.
 */
@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl<Menu, Menu> implements MenuService {
    @Autowired
    private MenuDAO dao;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    public void setMenuDAO(MenuDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }

    @Override
    public Menu createOrUpdate(Menu menu) throws Exception {
        if (menu.getId() == null) {
            Resource resource = new Resource();
            resource.setResource(menu.getResrouce());
            resource.setType(Resource.TypeEnum.MENU.name());
            resource = resourceService.createOrUpdate(resource);
            menu.setResourceId(resource.getId());
            return create(menu);
        } else {
            Resource resource = new Resource();
            resource.setId(menu.getResourceId());
            resource.setResource(menu.getResrouce());
            resource = resourceService.createOrUpdate(resource);
            resourceService.createOrUpdate(resource);
            return update(menu);
        }
    }
}
