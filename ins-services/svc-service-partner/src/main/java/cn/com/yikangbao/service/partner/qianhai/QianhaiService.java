package cn.com.yikangbao.service.partner.qianhai;

import cn.com.yikangbao.entity.qianhai.QianHaiOrder;

public interface QianhaiService {
    void createOrderByPartner(QianHaiOrder partnerOrder) throws Exception;
    void updateOrderByPartner(QianHaiOrder partnerOrder) throws Exception;
    void synchronousOrderStatus();
}
