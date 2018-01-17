package cn.com.yikangbao.entity.wechat.qrcode;

import cn.com.yikangbao.entity.common.Base;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.type.Alias;

@Alias("LocalWechatQRCodeM")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LocalWechatQRCode extends Base {
    /**
     * 推广渠道
     */
    private String channels;

    /**
     * 二维码地址
     */
    private String qrCodeUrl;

    /***
     * 编码
     */
    private String scene;
    /**
     * 扫描次数
     */
    private Integer scanTime;

    private String ticket;

    public String getChannels() {
        return channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public Integer getScanTime() {
        return scanTime;
    }

    public void setScanTime(Integer scanTime) {
        this.scanTime = scanTime;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "LocalWechatQRCode{" +
                "channels='" + channels + '\'' +
                ", qrCodeUrl='" + qrCodeUrl + '\'' +
                ", scene='" + scene + '\'' +
                ", scanTime=" + scanTime +
                ", ticket='" + ticket + '\'' +
                '}';
    }
}
