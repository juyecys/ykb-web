package cn.com.yikangbao.utils.partner;

import cn.com.yikangbao.entity.order.Order;
import cn.com.yikangbao.entity.qianhai.QianHaiOrder;

/**
 * Created by jeysine on 2018/2/1.
 */
public class PartnerOrderUtils {
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
        order.setCreatedDate(qianHaiOrder.getCreatedDate());
        order.setOrderDate(qianHaiOrder.getOrderDate());

        return order;
    }
}
