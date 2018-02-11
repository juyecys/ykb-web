package cn.com.yikangbao.entity.wechat.result;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class WechatCommonResult implements Serializable{


	private static final long serialVersionUID = -1742723432270871826L;
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

	@Override
	public String toString() {
		return "WechatCommonResult{" +
				"errcode=" + errcode +
				", errmsg='" + errmsg + '\'' +
				'}';
	}
}
