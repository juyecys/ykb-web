package cn.com.yikangbao.entity.wechat.result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WechatCommonResult {
	@JsonProperty("errcode")
	private Long errcode;
	@JsonProperty("errmsg")
	private String errmsg;

	public Long getErrcode() {
		return errcode;
	}

	public void setErrcode(Long errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}
