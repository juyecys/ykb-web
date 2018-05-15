package cn.com.yikangbao.entity.channel;

import cn.com.yikangbao.entity.common.Base;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.ibatis.type.Alias;

@Alias("BdChannelM")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BdChannel extends Base {
    /**
     * 推广渠道
     */
    @JsonProperty("channels")
    private String channels;

    @JsonProperty("channels_code")
    private String channelsCode;
    /**
     * 二维码地址
     */
    @JsonProperty("qr_code_url")
    private String qrCodeUrl;


    @JsonProperty("bd")
    private String bd;

}
