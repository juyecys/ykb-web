package cn.com.yikangbao.service.order.impl;

import cn.com.yikangbao.dao.order.OrderDAO;
import cn.com.yikangbao.entity.order.Order;
import cn.com.yikangbao.entity.order.OrderDTO;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import cn.com.yikangbao.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jeysine on 2018/2/1.
 */
@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderDTO> implements OrderService {
    @Autowired
    private OrderDAO dao;

    @Autowired
    public void setDao(OrderDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }

    @Override
    public List<OrderDTO> findNeedSysByStatus() {
        return dao.findNeedSysByStatus();
    }

    @Override
    public void synchronousOrderStatus(Order order) {
        dao.synchronousOrderStatus(order);
    }
}
