package cn.com.yikangbao.entity.qianhai;

import cn.com.yikangbao.entity.hospital.HospitalDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jeysine on 2018/2/5.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class QianHaiHospital extends HospitalDTO {

    @JsonProperty("sign")
    private String sign;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return super.toString() + "PartnerHospital{" +
                "sign='" + sign + '\'' +
                '}';
    }
}
