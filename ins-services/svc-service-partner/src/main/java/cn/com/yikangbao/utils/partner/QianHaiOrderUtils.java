package cn.com.yikangbao.utils.partner;

import cn.com.yikangbao.entity.order.Order;
import cn.com.yikangbao.entity.qianhai.QianHaiOrder;

import java.util.HashMap;

/**
 * Created by jeysine on 2018/2/1.
 */
public class QianHaiOrderUtils {
    public static Order transformPartnerOrder(QianHaiOrder qianHaiOrder) {
        Order order = new Order();

        order.setHospitalId(qianHaiOrder.getHospitalId());
        order.setHospitalName(qianHaiOrder.getHospitalName());
        order.setInsuranceAmount(qianHaiOrder.getInsuranceAmount());
        order.setInsuranceEndDate(qianHaiOrder.getInsuranceEndDate());
        order.setInsuranceStartDate(qianHaiOrder.getInsuranceStartDate());
        order.setInsuredCredentialsNum(qianHaiOrder.getInsuredCredentialsNum());
        order.setInsuredCredentialsType(qianHaiOrder.getInsuredCredentialsType());
        order.setInsuredName(qianHaiOrder.getInsuredName());
        order.setInsuredPhone(qianHaiOrder.getInsuredPhone());
        order.setOrderAmount(qianHaiOrder.getOrderAmount());
        order.setOrderNumber(qianHaiOrder.getOrderNumber());
        order.setProposerCredentialsNum(qianHaiOrder.getProposerCredentialsNum());
        order.setProposerCredentialsType(qianHaiOrder.getProposerCredentialsType());
        order.setProposerName(qianHaiOrder.getProposerName());
        order.setProposerPhone(qianHaiOrder.getProposerPhone());
        order.setRelation(qianHaiOrder.getRelation());
        order.setStatus(qianHaiOrder.getStatus());
        order.setUserId(qianHaiOrder.getUserId());
        order.setOrderDate(qianHaiOrder.getOrderDate());

        return order;
    }
    public static Order convertOrder(HashMap data) {
        Order order = new Order();
        order.setStatus((String) data.get("orderStatus"));
        order.setOrderNumber((String) data.get("orderId"));
        return order;
    }

    public static String transformQianHaiOrderStatus(String qianHaiStatus) {
        String status = null;
        switch (qianHaiStatus) {
            case "1": status = Order.OrderStatusEnum.WAIT_CONFIRM.name(); break;
            case "3": status = Order.OrderStatusEnum.WAIT_PAIED.name(); break;
            case "4": status = Order.OrderStatusEnum.PAIED.name(); break;
            case "7": status = Order.OrderStatusEnum.UNDERWRITE.name(); break;
        }
        return status;
    }
}
