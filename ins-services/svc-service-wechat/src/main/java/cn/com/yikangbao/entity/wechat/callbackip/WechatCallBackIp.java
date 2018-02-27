package cn.com.yikangbao.entity.wechat.callbackip;

import cn.com.yikangbao.entity.wechat.result.WechatCommonResult;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by jeysine on 2018/2/27.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class WechatCallBackIp extends WechatCommonResult {

    @JsonProperty("ip_list")
    private List<String> ipList;

    public List<String> getIpList() {
        return ipList;
    }

    public void setIpList(List<String> ipList) {
        this.ipList = ipList;
    }

    @Override
    public String toString() {
        return "WechatCallBackIp{" +
                "ipList=" + ipList +
                '}';
    }
}
