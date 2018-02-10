package cn.com.yikangbao.entity.wechatuser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.type.Alias;

/**
 * Created by jeysine on 2018/1/26.
 */
@Alias("LocalWechatUserQM")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LocalWechatUserDTO extends LocalWechatUser{

    @Override
    public String toString() {
        return super.toString();
    }

}
