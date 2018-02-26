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
    @JsonProperty("insurance_amount")
    private Long insuranceAmount;

    @JsonProperty("birthday")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;

    @JsonProperty("hospital_name")
    private String hospitalName;

    @JsonProperty("hospital_id")
    private String hospitalId;

    /**
     * 保费
     */
    @JsonProperty("order_amount")
    private Long orderAmount;

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

    @Override
    public String toString() {
        return "Insure{" +
                "insuranceAmount=" + insuranceAmount +
                ", birthday=" + birthday +
                ", hospitalName='" + hospitalName + '\'' +
                ", hospitalId='" + hospitalId + '\'' +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
