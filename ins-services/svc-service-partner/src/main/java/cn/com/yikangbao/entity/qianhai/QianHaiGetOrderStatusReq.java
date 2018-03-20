package cn.com.yikangbao.entity.qianhai;

/**
 * Created by jeysine on 2018/3/6.
 */
public class QianHaiGetOrderStatusReq {
    private String orderId;
    private String reqTime;
    private String userId;
    private final String actionType = QianHaiActionType.ORDER_STATUS.getValue();

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public String getActionType() {
        return actionType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "QianHaiGetOrderStatusReq{" +
                "orderId='" + orderId + '\'' +
                ", reqTime='" + reqTime + '\'' +
                ", userId='" + userId + '\'' +
                ", actionType='" + actionType + '\'' +
                '}';
    }
}
