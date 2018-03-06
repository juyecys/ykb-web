package cn.com.yikangbao.entity.qianhai;

/**
 * Created by jeysine on 2018/3/6.
 */
public enum QianHaiActionType {
    ENTRY("entry"),
    ORDER_DETAIL("orderDetail"),
    ORDER_STATUS("orderStatus");

    private String value;

    QianHaiActionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
