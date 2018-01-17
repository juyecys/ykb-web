package cn.com.yikangbao.entity.wechat.menu;

/**
 * Created by jeysine on 2018/1/25.
 */
public class WechatParentButton extends WechatButton {
    private WechatButton[] sub_button;

    public WechatButton[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(WechatButton[] sub_button) {
        this.sub_button = sub_button;
    }
}
