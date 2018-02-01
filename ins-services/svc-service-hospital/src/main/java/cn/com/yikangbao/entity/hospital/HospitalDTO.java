package cn.com.yikangbao.entity.hospital;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.type.Alias;

/**
 * Created by jeysine on 2018/2/5.
 */
@Alias("HospitalQM")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class HospitalDTO extends Hospital {
    private String provinceName;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return super.toString() + ",HospitaoDTO{" +
                "provinceName='" + provinceName + '\'' +
                '}';
    }
}
