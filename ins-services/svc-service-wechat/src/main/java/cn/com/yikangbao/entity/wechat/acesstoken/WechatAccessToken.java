package cn.com.yikangbao.entity.wechat.acesstoken;

import cn.com.yikangbao.entity.wechat.result.WechatCommonResult;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 调用微信接口所需的accesstoken
 */
public class WechatAccessToken extends WechatCommonResult{

	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("expires_in")
	private Long expiresIn;

	public WechatAccessToken() {
	}

	public WechatAccessToken(String accessToken, Long expiresIn) {
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	@Override
	public String toString() {
		return "WechatAccessToken{" +
				"accessToken='" + accessToken + '\'' +
				", expiresIn=" + expiresIn +
				'}';
	}
}
