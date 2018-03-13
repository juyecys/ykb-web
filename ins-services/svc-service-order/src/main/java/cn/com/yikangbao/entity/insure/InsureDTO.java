package cn.com.yikangbao.entity.insure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * Created by jeysine on 2018/3/13.
 */
@Alias("InsureQM")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class InsureDTO extends Insure{
    @JsonProperty("createdDateStart")
    private Date createdDateStart;

    @JsonProperty("createdDateEnd")
    private Date createdDateEnd;

    @JsonProperty("hospitalId")
    private String hospitalId;

    @JsonProperty("hospitalName")
    private String hospitalName;

    @JsonProperty("existOrder")
    private Boolean existOrder;

    @JsonProperty("nickName")
    private String nickName;

    @JsonProperty("provinceName")
    private String provinceName;

    public Date getCreatedDateStart() {
        return createdDateStart;
    }

    public void setCreatedDateStart(Date createdDateStart) {
        this.createdDateStart = createdDateStart;
    }

    public Date getCreatedDateEnd() {
        return createdDateEnd;
    }

    public void setCreatedDateEnd(Date createdDateEnd) {
        this.createdDateEnd = createdDateEnd;
    }

    @Override
    public String getHospitalId() {
        return hospitalId;
    }

    @Override
    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Override
    public String getHospitalName() {
        return hospitalName;
    }

    @Override
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Boolean getExistOrder() {
        return existOrder;
    }

    public void setExistOrder(Boolean existOrder) {
        this.existOrder = existOrder;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return "InsureDTO{" +
                "createdDateStart=" + createdDateStart +
                ", createdDateEnd=" + createdDateEnd +
                ", hospitalId='" + hospitalId + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", existOrder=" + existOrder +
                ", nickName='" + nickName + '\'' +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }
}
