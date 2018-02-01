package cn.com.yikangbao.entity.order;

import cn.com.yikangbao.entity.common.Base;
import cn.com.yikangbao.entity.questionnaire.Questionnaire;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;

/**
 * Created by jeysine on 2018/2/1.
 */
@Alias("OrderM")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class Order extends Base{

    /**
     * 投保人姓名
     */
    @JsonProperty("proposer_name")
    private String proposerName;

    /**
     * 投保人证件类型
     */
    @JsonProperty("proposer_credentials_type")
    private String proposerCredentialsType;

    /**
     * 投保人证件号码
     */
    @JsonProperty("proposer_credentials_num")
    private String proposerCredentialsNum;

    /**
     * 投保人手机号码
     */
    @JsonProperty("proposer_phone")
    private String proposerPhone;

    /**
     * 被保人项目
     */
    @JsonProperty("insured_name")
    private String insuredName;

    /**
     * 被保人证件类型
     */
    @JsonProperty("insured_credentials_type")
    private String insuredCredentialsType;

    /**
     * 被保人证件号码
     */
    @JsonProperty("insured_credentials_num")
    private String insuredCredentialsNum;

    /**
     * 被保人手机号码
     */
    @JsonProperty("insured_phone")
    private String insuredPhone;

    /**
     * 关系
     */
    @JsonProperty("relation")
    private String relation;

    /**
     * 医院id
     */
    @JsonProperty("hospital_id")
    private String hospitalId;

    /**
     * 医院名字
     */
    @JsonProperty("hospital_name")
    private String hospitalName;

    /**
     * 保障金额
     */
    @JsonProperty("insurance_amount")
    private Long insuranceAmount;

    /**
     * 保费
     */
    @JsonProperty("order_amount")
    private Long orderAmount;

    /**
     * 订单号
     */
    @JsonProperty("order_number")
    private String orderNumber;

    /**
     * 用户id
     */
    @JsonProperty("user_id")
    private String userId;

    /**
     * 订单状态
     */
    @JsonProperty("status")
    private String status;

    /**
     * 保障期限开始时间
     */
    @JsonProperty("insurance_start_date")
    private String insuranceStartDate;

    @JsonProperty("channel")
    private String channel;
    /**
     * 保障期限结束时间
     */
    @JsonProperty("insurance_end_date")
    private String insuranceEndDate;

    /**
     * 保单生效时间
     */
    @JsonProperty("policy_effective_date")
    private Date policyEffectiveDate;

    /**
     * 保单号
     */
    @JsonProperty("policy_number")
    private String policyNumber;

    /**
     * 状态原因
     */
    @JsonProperty("reason")
    private String reason;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @JsonProperty("order_date")
    private Date orderDate;


    public enum ChannelEnum {
        QIAN_HAI("前海");

        private String description;

        ChannelEnum(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public enum OrderStatusEnum {
        WAIT_CONFIRM("待确认")
        ,WAIT_PAIED("审核通过,待付款")
        ,AUDIT_NOT_THROUGH("审核不通过")
        ,PAIED("已支付")
        ,OVERTIME_PAIED("超时未支付")
        ,EFFECTIVE("已生效")
        ,END("结束");

        private String description;

        OrderStatusEnum(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public String getProposerName() {
        return proposerName;
    }

    public void setProposerName(String proposerName) {
        this.proposerName = proposerName;
    }

    public String getProposerCredentialsType() {
        return proposerCredentialsType;
    }

    public void setProposerCredentialsType(String proposerCredentialsType) {
        this.proposerCredentialsType = proposerCredentialsType;
    }

    public String getProposerCredentialsNum() {
        return proposerCredentialsNum;
    }

    public void setProposerCredentialsNum(String proposerCredentialsNum) {
        this.proposerCredentialsNum = proposerCredentialsNum;
    }

    public String getProposerPhone() {
        return proposerPhone;
    }

    public void setProposerPhone(String proposerPhone) {
        this.proposerPhone = proposerPhone;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getInsuredCredentialsType() {
        return insuredCredentialsType;
    }

    public void setInsuredCredentialsType(String insuredCredentialsType) {
        this.insuredCredentialsType = insuredCredentialsType;
    }

    public String getInsuredCredentialsNum() {
        return insuredCredentialsNum;
    }

    public void setInsuredCredentialsNum(String insuredCredentialsNum) {
        this.insuredCredentialsNum = insuredCredentialsNum;
    }

    public String getInsuredPhone() {
        return insuredPhone;
    }

    public void setInsuredPhone(String insuredPhone) {
        this.insuredPhone = insuredPhone;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Long getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(Long insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public Long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInsuranceStartDate() {
        return insuranceStartDate;
    }

    public void setInsuranceStartDate(String insuranceStartDate) {
        this.insuranceStartDate = insuranceStartDate;
    }

    public String getInsuranceEndDate() {
        return insuranceEndDate;
    }

    public void setInsuranceEndDate(String insuranceEndDate) {
        this.insuranceEndDate = insuranceEndDate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Date getPolicyEffectiveDate() {
        return policyEffectiveDate;
    }

    public void setPolicyEffectiveDate(Date policyEffectiveDate) {
        this.policyEffectiveDate = policyEffectiveDate;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Order{" +
                "proposerName='" + proposerName + '\'' +
                ", proposerCredentialsType='" + proposerCredentialsType + '\'' +
                ", proposerCredentialsNum='" + proposerCredentialsNum + '\'' +
                ", proposerPhone='" + proposerPhone + '\'' +
                ", insuredName='" + insuredName + '\'' +
                ", insuredCredentialsType='" + insuredCredentialsType + '\'' +
                ", insuredCredentialsNum='" + insuredCredentialsNum + '\'' +
                ", insuredPhone='" + insuredPhone + '\'' +
                ", relation='" + relation + '\'' +
                ", hospitalId='" + hospitalId + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", insuranceAmount=" + insuranceAmount +
                ", orderAmount=" + orderAmount +
                ", orderNumber='" + orderNumber + '\'' +
                ", userId='" + userId + '\'' +
                ", status='" + status + '\'' +
                ", insuranceStartDate='" + insuranceStartDate + '\'' +
                ", channel='" + channel + '\'' +
                ", insuranceEndDate='" + insuranceEndDate + '\'' +
                ", policyEffectiveDate=" + policyEffectiveDate +
                ", policyNumber='" + policyNumber + '\'' +
                ", reason='" + reason + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }
}
