package cn.com.yikangbao.service.wechat.localMenu.impl;

import cn.com.yikangbao.dao.wechat.localwechatmenu.LocalWechatMenuDAO;
import cn.com.yikangbao.entity.wechat.localwechatmenu.LocalWechatMenu;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import cn.com.yikangbao.service.wechat.localMenu.LocalWechatMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("localWechatMenuService")
public class LocalWechatMenuServiceImpl extends BaseServiceImpl<LocalWechatMenu, LocalWechatMenu> implements LocalWechatMenuService {
    @Autowired
    private LocalWechatMenuDAO dao;

    @Autowired
    private void setDao(LocalWechatMenuDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }

    @Override
    public List<LocalWechatMenu> findByCondition(LocalWechatMenu localWechatMenu) {
        return dao.findByCondition(localWechatMenu);
    }

    @Override
    public LocalWechatMenu createOrUpdate(LocalWechatMenu menu) throws Exception {
        LocalWechatMenu check = new LocalWechatMenu();
        check.setKey(menu.getKey());
        if (menu.getId() == null && isExistKey(menu)) {
            throw new Exception("微信菜单key不能重复");
        }
        if (menu.getId() == null && !isExistKey(menu)) {
            menu = create(menu);
        } else if (menu.getId() != null){
            menu = update(menu);
        }
        return menu;
    }

    private Boolean isExistKey(LocalWechatMenu menu) {
        LocalWechatMenu search = new LocalWechatMenu();
        search.setKey(menu.getKey());
        search = findOneByCondition(search);
        if (search == null) {
            return true;
        }
        return false;
    }
}
