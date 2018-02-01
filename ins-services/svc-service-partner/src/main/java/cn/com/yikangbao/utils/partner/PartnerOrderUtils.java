package cn.com.yikangbao.utils.partner;

import cn.com.yikangbao.entity.order.Order;
import cn.com.yikangbao.entity.partner.PartnerOrder;

/**
 * Created by jeysine on 2018/2/1.
 */
public class PartnerOrderUtils {
    public static Order transformPartnerOrder(PartnerOrder partnerOrder) {
        Order order = new Order();

        order.setHospitalId(partnerOrder.getHospitalId());
        order.setHospitalName(partnerOrder.getHospitalName());
        order.setInsuranceAmount(partnerOrder.getInsuranceAmount());
        order.setInsuranceEndDate(partnerOrder.getInsuranceEndDate());
        order.setInsuranceStartDate(partnerOrder.getInsuranceStartDate());
        order.setInsuredCredentialsNum(partnerOrder.getInsuredCredentialsNum());
        order.setInsuredCredentialsType(partnerOrder.getInsuredCredentialsType());
        order.setInsuredName(partnerOrder.getInsuredName());
        order.setInsuredPhone(partnerOrder.getInsuredPhone());
        order.setOrderAmount(partnerOrder.getOrderAmount());
        order.setOrderNumber(partnerOrder.getOrderNumber());
        order.setProposerCredentialsNum(partnerOrder.getProposerCredentialsNum());
        order.setProposerCredentialsType(partnerOrder.getProposerCredentialsType());
        order.setProposerName(partnerOrder.getProposerName());
        order.setProposerPhone(partnerOrder.getProposerPhone());
        order.setRelation(partnerOrder.getRelation());
        order.setStatus(partnerOrder.getStatus());
        order.setUserId(partnerOrder.getUserId());
        order.setCreatedDate(partnerOrder.getCreatedDate());
        order.setOrderDate(partnerOrder.getOrderDate());

        return order;
    }
}
