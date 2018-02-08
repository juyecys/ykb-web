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
    /**
     * 推广渠道
     */
    private String channels;

    public String getChannels() {
        return channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return super.toString() + " WechatUserDTO{" +
                "channels='" + channels + '\'' +
                '}';
    }

}
