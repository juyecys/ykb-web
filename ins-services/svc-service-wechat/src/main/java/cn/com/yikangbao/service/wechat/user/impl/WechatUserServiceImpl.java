package cn.com.yikangbao.service.wechat.user.impl;


import cn.com.yikangbao.contants.wechat.WechatConfigParams;
import cn.com.yikangbao.entity.wechat.acesstoken.WechatAccessToken;
import cn.com.yikangbao.entity.wechat.user.WechatUser;
import cn.com.yikangbao.service.wechat.accesstoken.WechatAccessTokenService;
import cn.com.yikangbao.service.wechat.user.WechatUserService;
import cn.com.yikangbao.untils.common.okhttputil.OkHttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("wechatUserService")
public class WechatUserServiceImpl implements WechatUserService {
	@Autowired
	private WechatAccessTokenService wechatAccessTokenService;

	private static final ObjectMapper mapper = new ObjectMapper();
	@Override
	public WechatUser getWechatUserInfo(String openid, String lang) throws IOException {
		WechatAccessToken wechatAccessToken = wechatAccessTokenService.getAccessToken();
		String url = WechatConfigParams.WEHCAT_GET_USER_URL.replace("ACCESS_TOKEN", wechatAccessToken.getAccessToken())
				.replace("OPENID", openid);
		String result = OkHttpUtils.get().url(url).build().execute().body().string();

		return mapper.readValue(result, WechatUser.class);
	}

	@Override
	public List<WechatUser> getWechatUserInfoList(List<String> openids) throws IOException {
		WechatAccessToken wechatAccessToken = wechatAccessTokenService.getAccessToken();
		String url = WechatConfigParams.WECHAT_GET_USER_LIST_URL.replace("ACCESS_TOKEN", wechatAccessToken.getAccessToken());
		Map<String, Object> map = new HashMap<>();
		map.put("user_list", openids);
		String properties = mapper.writeValueAsString(map);
		String result = OkHttpUtils.postString().url(url).content(properties).build().execute().body().string();

		return mapper.readValue(result,
				mapper.getTypeFactory().constructParametricType(List.class, WechatUser.class));
	}

	@Override
	public WechatUser getWechatUserInfoByAuth(String authAccessToken, String openid) throws IOException {
		String url = WechatConfigParams.WECHAT_GET_USER_BY_AUTH_URL.replace("ACCESS_TOKEN", authAccessToken)
				.replace("OPENID", openid);
		String result = OkHttpUtils.get().url(url).build().execute().body().string();

		return mapper.readValue(result, WechatUser.class);
	}
}
