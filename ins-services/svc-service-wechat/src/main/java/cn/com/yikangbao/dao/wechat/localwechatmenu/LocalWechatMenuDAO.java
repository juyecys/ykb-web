package cn.com.yikangbao.dao.wechat.localwechatmenu;

import cn.com.yikangbao.dao.common.BaseDAO;
import cn.com.yikangbao.entity.wechat.localwechatmenu.LocalWechatMenu;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LocalWechatMenuDAO extends BaseDAO<LocalWechatMenu, LocalWechatMenu> {
    List<LocalWechatMenu> findByCondition(LocalWechatMenu localWechatMenu);
}
