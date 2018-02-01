package cn.com.yikangbao.service.partner.qianhai;

import cn.com.yikangbao.entity.partner.PartnerOrder;

public interface QianhaiService {
    void createOrderByPartner(PartnerOrder partnerOrder);
    void updateOrderByPartner(PartnerOrder partnerOrder);
}
