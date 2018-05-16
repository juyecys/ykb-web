package cn.com.yikangbao.entity.channel;

import cn.com.yikangbao.entity.common.Base;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.ibatis.type.Alias;

@Alias("BdChannelM")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BdChannel extends Base {
    /**
     * 推广渠道
     */
    @JsonProperty("channels")
    private String channels;

    @JsonProperty("channels_code")
    private String channelsCode;
    /**
     * 二维码地址
     */
    @JsonProperty("qr_code_url")
    private String qrCodeUrl;


    @JsonProperty("bd")
    private String bd;


    @JsonProperty("remark")
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getChannels() {
        return channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    public String getChannelsCode() {
        return channelsCode;
    }

    public void setChannelsCode(String channelsCode) {
        this.channelsCode = channelsCode;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    @Override
    public String toString() {
        return "BdChannel{" +
                "channels='" + channels + '\'' +
                ", channelsCode='" + channelsCode + '\'' +
                ", qrCodeUrl='" + qrCodeUrl + '\'' +
                ", bd='" + bd + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
