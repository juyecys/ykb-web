package cn.com.yikangbao.entity.hospital;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.ibatis.type.Alias;

/**
 * Created by jeysine on 2018/2/5.
 */
@Alias("HospitalQM")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class HospitalDTO extends Hospital {

}
