package cn.com.yikangbao.service.wechat.localMenu;

import cn.com.yikangbao.entity.wechat.localwechatmenu.LocalWechatMenu;
import cn.com.yikangbao.service.common.BaseService;

import java.util.List;

public interface LocalWechatMenuService extends BaseService<LocalWechatMenu, LocalWechatMenu> {
    LocalWechatMenu createOrUpdate(LocalWechatMenu localWechatMenu) throws Exception;

}
