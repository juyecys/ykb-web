package cn.com.yikangbao.entity.orderrecord;

import cn.com.yikangbao.entity.common.Base;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.ibatis.type.Alias;

/**
 * Created by jeysine on 2018/2/5.
 */
@Alias("OrderRecordM")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class OrderRecord extends Base{

    @JsonProperty("status")
    private String status;

    @JsonProperty("order_number")
    private String orderNumber;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return super.toString() + ", OrderRecord{" +
                "status='" + status + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                '}';
    }
}
