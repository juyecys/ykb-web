package cn.com.yikangbao.service.wechat.user;

import cn.com.yikangbao.entity.wechat.user.WechatUser;

import java.io.IOException;
import java.util.List;

public interface WechatUserService {
	WechatUser getWechatUserInfo(String openid, String lang) throws IOException;
	List<WechatUser> getWechatUserInfoList(List<String> openids) throws IOException;
	WechatUser getWechatUserInfoByAuth(String authAccessToken, String openid) throws IOException;
}
