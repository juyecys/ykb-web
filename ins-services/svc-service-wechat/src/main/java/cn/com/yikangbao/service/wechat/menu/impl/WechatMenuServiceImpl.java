package cn.com.yikangbao.service.wechat.menu.impl;


import cn.com.yikangbao.contants.wechat.WechatConfigParams;
import cn.com.yikangbao.contants.wechat.WechatReponseCodeEmnu;
import cn.com.yikangbao.entity.wechat.acesstoken.WechatAccessToken;
import cn.com.yikangbao.entity.wechat.localwechatmenu.LocalWechatMenu;
import cn.com.yikangbao.entity.wechat.menu.*;
import cn.com.yikangbao.entity.wechat.result.WechatCommonResult;
import cn.com.yikangbao.service.wechat.accesstoken.WechatAccessTokenService;
import cn.com.yikangbao.service.wechat.localMenu.LocalWechatMenuService;
import cn.com.yikangbao.service.wechat.menu.WechatMenuService;
import cn.com.yikangbao.untils.common.okhttputil.OkHttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("wechatMenuService")
public class WechatMenuServiceImpl implements WechatMenuService {
	private static Logger logger = LoggerFactory.getLogger(WechatMenuServiceImpl.class);
	private static final ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private WechatAccessTokenService wechatAccessTokenService;

	@Autowired
	private LocalWechatMenuService localWechatMenuService;
	@Override
	public Boolean createWechatMenu(WechatMenu wechatMenu) throws IOException {
		WechatAccessToken accessToken = wechatAccessTokenService.getAccessToken();

		String url = WechatConfigParams.WECHAT_CREATE_MENU_URL.replace("ACCESS_TOKEN", accessToken.getAccessToken());

		String wechatMenuJson = mapper.writeValueAsString(wechatMenu);
		logger.debug("wechatMenuJson:{}",wechatMenuJson);
		Response response = OkHttpUtils.postString().content(wechatMenuJson).url(url).build().execute();
		WechatCommonResult result = mapper.readValue(response.body().string(),WechatCommonResult.class);
		if (WechatReponseCodeEmnu.OK.getMsg().equals(result.getErrmsg())) {
			logger.debug("create wechat menu success,code:{},msg:{}", result.getErrcode(), result.getErrmsg());
			return true;
		} else {
			logger.error("create wechat menu falid,errorcode:{},errormsg:{}", result.getErrcode(), result.getErrmsg());
		}
		return false;
	}

	@Override
	public String getWechatMenu() throws IOException {
		WechatAccessToken accessToken = wechatAccessTokenService.getAccessToken();
		String url = WechatConfigParams.WECHAT_GET_MENU_URL.replace("ACCESS_TOKEN", accessToken.getAccessToken());
		Response response = OkHttpUtils.get().url(url).build().execute();
		String result = response.body().string();
		logger.debug("get wechat menu result:{}",result);
		return result;
	}

	@Override
	public WechatCommonResult deleteWechatMenu() throws IOException {
		WechatAccessToken accessToken = wechatAccessTokenService.getAccessToken();
		String url = WechatConfigParams.WECHAT_DELETE_MENU_URL.replace("ACCESS_TOKEN", accessToken.getAccessToken());
		Response response = OkHttpUtils.get().url(url).build().execute();
		WechatCommonResult result = mapper.readValue(response.body().string(),WechatCommonResult.class);
		if (WechatReponseCodeEmnu.OK.getCode().equals(result.getErrcode())) {
			logger.debug("delete wechat menu success:{}",result);
		} else {
			logger.error("delete wechat menu faild,errcode:{},errmsg:{}",result.getErrcode(),result.getErrmsg());
		}
		return result;
	}

	@Override
	public Boolean generateWechatMenu() throws IOException {
		WechatMenu wechatMenu = generateWechatMenuData();
		return createWechatMenu(wechatMenu);
	}

	private WechatMenu generateWechatMenuData() {
		LocalWechatMenu search = new LocalWechatMenu();
		search.setLevel(1);
		List<LocalWechatMenu> wechatParentMenuList =localWechatMenuService.findByCondition(search);

		if (wechatParentMenuList.isEmpty()) {
			return null;
		}


		WechatButton[] buttons = new WechatButton[wechatParentMenuList.size()];
		for (int i = 0; i < wechatParentMenuList.size(); i++) {
			LocalWechatMenu menu = wechatParentMenuList.get(i);
			if (isViewButton(menu.getType())) {
				buttons[i] = getViewButton(menu);
			} else if (isClickButton(menu.getType())) {
				buttons[i] = getClickButton(menu);
			} else if (isParentButton(menu.getType())) {
				search.setLevel(2);
				search.setParentId(menu.getId());
				List<LocalWechatMenu> subMenuList = localWechatMenuService.findByCondition(search);
				WechatButton[] subButtons = new WechatButton[subMenuList.size()];
				for (int j = 0; j < subMenuList.size(); j++) {

					LocalWechatMenu subMenu = subMenuList.get(j);
					if (isViewButton(subMenu.getType())) {
						subButtons[j] = getViewButton(subMenu);
					} else if (isClickButton(subMenu.getType())) {
						subButtons[j] = getClickButton(subMenu);
					}
				}
				WechatParentButton parentButton = new WechatParentButton();
				parentButton.setName(menu.getName());
				parentButton.setSub_button(subButtons);
				buttons[i] = parentButton;
			}
		}
		WechatMenu wechatMenu = new WechatMenu();
		wechatMenu.setButton(buttons);
		return wechatMenu;
	}


	private WechatViewButton getViewButton(LocalWechatMenu menu){
		WechatViewButton viewButton = new WechatViewButton();
		viewButton.setType("view");
		viewButton.setUrl(menu.getUrl());
		viewButton.setName(menu.getName());
		return viewButton;
	}
	private WechatClickButton getClickButton(LocalWechatMenu menu) {
		WechatClickButton clickButton = new WechatClickButton();
		clickButton.setKey(menu.getKey());
		clickButton.setType("click");
		clickButton.setName(menu.getName());
		return clickButton;
	}

	private boolean isViewButton(String type) {
		return LocalWechatMenu.WechatMenuTypeEnum.VIEW.getValue().equals(type);
	}

	private boolean isClickButton(String type) {
		return LocalWechatMenu.WechatMenuTypeEnum.ARTICLE.getValue().equals(type)
				|| LocalWechatMenu.WechatMenuTypeEnum.TEXT.getValue().equals(type)
				|| LocalWechatMenu.WechatMenuTypeEnum.CLICK.getValue().equals(type);
	}

	private boolean isParentButton(String type) {
		return LocalWechatMenu.WechatMenuTypeEnum.GROUP.getValue().equals(type);
	}

}
