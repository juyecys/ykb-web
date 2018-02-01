package cn.com.yikangbao.service.order;

import cn.com.yikangbao.entity.order.Order;
import cn.com.yikangbao.entity.order.OrderDTO;
import cn.com.yikangbao.service.common.BaseService;

import java.util.List;

/**
 * Created by jeysine on 2018/2/1.
 */
public interface OrderService extends BaseService<Order, OrderDTO>{
    List<OrderDTO> findNeedSysByStatus();
    void synchronousOrderStatus(Order order);
}
