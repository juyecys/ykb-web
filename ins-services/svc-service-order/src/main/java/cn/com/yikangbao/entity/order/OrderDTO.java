package cn.com.yikangbao.entity.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * Created by jeysine on 2018/2/1.
 */
@Alias("OrderQM")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class OrderDTO extends Order {

    @JsonProperty("createdDateStart")
    private Date createdDateStart;

    @JsonProperty("createdDateEnd")
    private Date createdDateEnd;

    @JsonProperty("nickName")
    private String nickName;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "createdDateStart=" + createdDateStart +
                ", createdDateEnd=" + createdDateEnd +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
