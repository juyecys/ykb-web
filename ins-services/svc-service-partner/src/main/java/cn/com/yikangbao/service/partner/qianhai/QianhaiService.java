package cn.com.yikangbao.service.partner.qianhai;

import cn.com.yikangbao.entity.order.OrderDTO;
import cn.com.yikangbao.entity.qianhai.QianHaiOrder;

import java.util.List;

public interface QianhaiService {
    void createOrderByPartner(QianHaiOrder partnerOrder) throws Exception;
    void updateOrderByPartner(QianHaiOrder partnerOrder) throws Exception;
    void synchronousOrderStatus(List<OrderDTO> orders);
}
