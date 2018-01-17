package cn.com.yikangbao.entity.wechat.menu;

/**
 * 微信click类型的菜单
 */
public class WechatClickButton extends WechatButton {
	private String type;

	private String key;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
