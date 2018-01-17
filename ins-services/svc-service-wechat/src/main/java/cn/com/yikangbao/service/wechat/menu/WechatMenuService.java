package cn.com.yikangbao.service.wechat.menu;



import cn.com.yikangbao.entity.wechat.menu.WechatMenu;
import cn.com.yikangbao.entity.wechat.result.WechatCommonResult;

import java.io.IOException;

public interface WechatMenuService {
	Boolean createWechatMenu(WechatMenu wechatMenu) throws IOException;
	String getWechatMenu() throws IOException;
	WechatCommonResult deleteWechatMenu() throws IOException;
	Boolean generateWechatMenu() throws IOException;
}
