package cn.com.yikangbao.utils.partner;

import cn.com.yikangbao.entity.order.Order;

import java.util.HashMap;

public class PartnerConvertUtils {
    public static Order convertOrder(HashMap data) {
        Order order = new Order();
        order.setStatus((String) data.get("orderStatus"));
        order.setOrderNumber((String) data.get("orderId"));
        return order;
    }
}
