package cn.com.yikangbao.dao.order;

import cn.com.yikangbao.dao.common.BaseDAO;
import cn.com.yikangbao.entity.order.Order;
import cn.com.yikangbao.entity.order.OrderDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jeysine on 2018/2/1.
 */
@Component
public interface OrderDAO extends BaseDAO<Order, Order> {
    List<OrderDTO> findNeedSysByStatus();
    void synchronousOrderStatus(Order order);
}
