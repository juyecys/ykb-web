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
@JsonInclude(JsonInclude.Include.NON_NULL )
public class Order extends Base{

    @JsonProperty("name")
    private String name;

    /**
     * 投保人姓名
     */
    @JsonProperty("proposerName")
    private String proposerName;

    /**
     * 投保人年龄
     */
    @JsonProperty("proposerAge")
    private Integer proposerAge;

    /**
     * 投保人性别
     */
    @JsonProperty("proposerGender")
    private String proposerGender;

    /**
     * 投保人证件类型
     */
    @JsonProperty("proposerCredentialsType")
    private String proposerCredentialsType;

    /**
     * 投保人证件号码
     */
    @JsonProperty("proposerCredentialsNum")
    private String proposerCredentialsNum;

    /**
     * 投保人手机号码
     */
    @JsonProperty("proposerPhone")
    private String proposerPhone;

    /**
     * 被保人姓名
     */
    @JsonProperty("insuredName")
    private String insuredName;

    /**
     * 被保人年龄
     */
    @JsonProperty("insuredAge")
    private Integer insuredAge;

    /**
     * 被保人性别
     */
    @JsonProperty("insuredGender")
    private String insuredGender;

    /**
     * 被保人证件类型
     */
    @JsonProperty("insuredCredentialsType")
    private String insuredCredentialsType;

    /**
     * 被保人证件号码
     */
    @JsonProperty("insuredCredentialsNum")
    private String insuredCredentialsNum;

    /**
     * 被保人手机号码
     */
    @JsonProperty("insuredPhone")
    private String insuredPhone;

    /**
     * 关系
     */
    @JsonProperty("relation")
    private String relation;

    /**
     * 医院id
     */
    @JsonProperty("hospitalId")
    private String hospitalId;

    /**
     * 医院名字
     */
    @JsonProperty("hospitalName")
    private String hospitalName;

    /**
     * 保障金额
     */
    @JsonProperty("insuranceAmount")
    private Long insuranceAmount;

    /**
     * 保费
     */
    @JsonProperty("orderAmount")
    private Long orderAmount;

    /**
     * 订单号
     */
    @JsonProperty("orderNumber")
    private String orderNumber;

    /**
     * 第三方订单id
     */
    @JsonProperty("partnerOrderId")
    private String partnerOrderId;

    /**
     * 用户id
     */
    @JsonProperty("userId")
    private String userId;

    /**
     * 订单状态
     */
    @JsonProperty("status")
    private String status;

    /**
     * 保障期限开始时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @JsonProperty("insuranceStartDate")
    private Date insuranceStartDate;

    @JsonProperty("bdchannel")
    private String channel;
    /**
     * 保障期限结束时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @JsonProperty("insuranceEndDate")
    private Date insuranceEndDate;

    /**
     * 保单生效时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @JsonProperty("policyEffectiveDate")
    private Date policyEffectiveDate;

    /**
     * 保单号
     */
    @JsonProperty("policyNumber")
    private String policyNumber;

    /**
     * 状态原因
     */
    @JsonProperty("reason")
    private String reason;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @JsonProperty("orderDate")
    private Date orderDate;

    @JsonProperty("remark")
    private String remark;

    /*订单来源*/
    @JsonProperty("source")
    private String source;

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
        ,WAIT_AUDIT("待审核")
        ,WAIT_PAIED("审核通过,待付款")
        ,AUDIT_NOT_THROUGH("审核不通过")
        ,PAIED("已支付")
        ,OVERTIME_PAIED("超时未支付")
        ,UNDERWRITE("已承保")
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", proposerName='" + proposerName + '\'' +
                ", proposerAge=" + proposerAge +
                ", proposerGender='" + proposerGender + '\'' +
                ", proposerCredentialsType='" + proposerCredentialsType + '\'' +
                ", proposerCredentialsNum='" + proposerCredentialsNum + '\'' +
                ", proposerPhone='" + proposerPhone + '\'' +
                ", insuredName='" + insuredName + '\'' +
                ", insuredAge=" + insuredAge +
                ", insuredGender='" + insuredGender + '\'' +
                ", insuredCredentialsType='" + insuredCredentialsType + '\'' +
                ", insuredCredentialsNum='" + insuredCredentialsNum + '\'' +
                ", insuredPhone='" + insuredPhone + '\'' +
                ", relation='" + relation + '\'' +
                ", hospitalId='" + hospitalId + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", insuranceAmount=" + insuranceAmount +
                ", orderAmount=" + orderAmount +
                ", orderNumber='" + orderNumber + '\'' +
                ", partnerOrderId='" + partnerOrderId + '\'' +
                ", userId='" + userId + '\'' +
                ", status='" + status + '\'' +
                ", insuranceStartDate=" + insuranceStartDate +
                ", bdchannel='" + channel + '\'' +
                ", insuranceEndDate=" + insuranceEndDate +
                ", policyEffectiveDate=" + policyEffectiveDate +
                ", policyNumber='" + policyNumber + '\'' +
                ", reason='" + reason + '\'' +
                ", orderDate=" + orderDate +
                ", remark='" + remark + '\'' +
                ", source='" + source + '\'' +
                '}';
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

    public Date getInsuranceStartDate() {
        return insuranceStartDate;
    }

    public void setInsuranceStartDate(Date insuranceStartDate) {
        this.insuranceStartDate = insuranceStartDate;
    }

    public Date getInsuranceEndDate() {
        return insuranceEndDate;
    }

    public void setInsuranceEndDate(Date insuranceEndDate) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartnerOrderId() {
        return partnerOrderId;
    }

    public void setPartnerOrderId(String partnerOrderId) {
        this.partnerOrderId = partnerOrderId;
    }


    public Integer getProposerAge() {
        return proposerAge;
    }

    public void setProposerAge(Integer proposerAge) {
        this.proposerAge = proposerAge;
    }

    public Integer getInsuredAge() {
        return insuredAge;
    }

    public void setInsuredAge(Integer insuredAge) {
        this.insuredAge = insuredAge;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProposerGender() {
        return proposerGender;
    }

    public void setProposerGender(String proposerGender) {
        this.proposerGender = proposerGender;
    }

    public String getInsuredGender() {
        return insuredGender;
    }

    public void setInsuredGender(String insuredGender) {
        this.insuredGender = insuredGender;
    }

}
