package cn.com.yikangbao.entity.qianhai;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by jeysine on 2018/2/28.
 */

/**
 * 用于与前海交互
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class QianHaiOrder extends CommonQianHai{

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("insuranceAmount")
    private String insuranceAmount;

    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;

    @JsonProperty("hospitalCode")
    private String hospitalCode;

    @JsonProperty("trialPremium")
    private String trialPremium;



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(String insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public String getTrialPremium() {
        return trialPremium;
    }

    public void setTrialPremium(String trialPremium) {
        this.trialPremium = trialPremium;
    }

    @Override
    public String toString() {
        return super.toString() + "InsureQianHai{" +
                "userId='" + userId + '\'' +
                ", insuranceAmount='" + insuranceAmount + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", hospitalCode='" + hospitalCode + '\'' +
                ", trialPremium='" + trialPremium + '\'' +
                '}';
    }
}
