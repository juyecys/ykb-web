package cn.com.yikangbao.service.partner.qianhai;

import cn.com.yikangbao.entity.partner.PartnerOrder;
import cn.com.yikangbao.entity.qianhai.QianHaiOrder;
import cn.com.yikangbao.exception.QianHaiException;

import java.io.IOException;

public interface QianhaiService {
    void createOrderByPartner(PartnerOrder partnerOrder);
    void updateOrderByPartner(PartnerOrder partnerOrder);
    void sendOrder(QianHaiOrder insure) throws IOException, QianHaiException, IllegalAccessException;
    void getOrderDetail(QianHaiOrder order) throws IOException, QianHaiException, IllegalAccessException;
}
