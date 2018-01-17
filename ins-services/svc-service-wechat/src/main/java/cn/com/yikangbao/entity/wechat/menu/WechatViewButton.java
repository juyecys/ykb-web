package cn.com.yikangbao.entity.wechat.menu;

/**
 * 微信view类型的菜单
 */
public class WechatViewButton extends WechatButton{
	private String type;

	private String url;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
