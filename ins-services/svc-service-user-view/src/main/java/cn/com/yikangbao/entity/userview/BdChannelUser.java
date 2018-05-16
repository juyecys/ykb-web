package cn.com.yikangbao.entity.userview;

import cn.com.yikangbao.entity.common.Base;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("BdChannelUserM")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BdChannelUser extends Base {

    @JsonProperty("bd_channel_id")
    private String bdChannelId;

    @JsonProperty("mobile")
    private String mobile;

    @JsonProperty("weixin_id")
    private String weixinId;


    @JsonProperty("order_no")
    private String orderNo;


    @JsonProperty("remark")
    private String remark;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date birthDay;

    public String getBdChannelId() {
        return bdChannelId;
    }

    public void setBdChannelId(String bdChannelId) {
        this.bdChannelId = bdChannelId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }


    @Override
    public String toString() {
        return "BdChannelUser{" +
                "bdChannelId='" + bdChannelId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", weixinId='" + weixinId + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", remark='" + remark + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}