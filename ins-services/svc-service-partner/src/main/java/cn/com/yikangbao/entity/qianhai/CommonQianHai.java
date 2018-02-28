package cn.com.yikangbao.entity.qianhai;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by jeysine on 2018/2/28.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CommonQianHai {

    @JsonProperty("code")
    private String code;

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("reqTime")
    private String reqTime;

    @JsonProperty("sign")
    private String sign;

    @JsonProperty("actionType")
    private String actionType;

    public static enum ActionTypeEnum {
        ORDER_DETAIL("orderDetail"),
        ENTRY("entry");

        private String value;

        ActionTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    @Override
    public String toString() {
        return "CommonQianHai{" +
                "code='" + code + '\'' +
                ", desc='" + desc + '\'' +
                ", reqTime=" + reqTime +
                ", sign='" + sign + '\'' +
                ", actionType='" + actionType + '\'' +
                '}';
    }
}
