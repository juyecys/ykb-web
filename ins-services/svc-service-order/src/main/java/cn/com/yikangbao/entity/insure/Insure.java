package cn.com.yikangbao.entity.insure;

import cn.com.yikangbao.entity.common.Base;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * Created by jeysine on 2018/2/26.
 */
@Alias("InsureM")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class Insure extends Base {
    /**
     * 保障金额
     */
    @JsonProperty("insuranceAmount")
    private Long insuranceAmount;

    @JsonProperty("birthday")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("hospitalName")
    private String hospitalName;

    @JsonProperty("hospitalId")
    private String hospitalId;

    /**
     * 保费
     */
    @JsonProperty("orderAmount")
    private Long orderAmount;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("openId")
    private String openId;

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("partnerOrderId")
    private String partnerOrderId;

    @JsonProperty("orderNumber")
    private String orderNumber;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(Long insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPartnerOrderId() {
        return partnerOrderId;
    }

    public void setPartnerOrderId(String partnerOrderId) {
        this.partnerOrderId = partnerOrderId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "Insure{" +
                "insuranceAmount=" + insuranceAmount +
                ", birthday=" + birthday +
                ", age=" + age +
                ", hospitalName='" + hospitalName + '\'' +
                ", hospitalId='" + hospitalId + '\'' +
                ", orderAmount=" + orderAmount +
                ", userId='" + userId + '\'' +
                ", openId='" + openId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", partnerOrderId='" + partnerOrderId + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                '}';
    }

}
