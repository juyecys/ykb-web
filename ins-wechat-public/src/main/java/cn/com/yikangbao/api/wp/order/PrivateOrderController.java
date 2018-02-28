package cn.com.yikangbao.api.wp.order;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.order.OrderDTO;
import cn.com.yikangbao.service.order.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = { "/ykb/wp/private/order","/ykb/wp/public/order" }, produces = "application/json")
public class PrivateOrderController {
    private static final Logger logger = LoggerFactory.getLogger(PrivateOrderController.class);

    @Autowired
    private OrderService orderService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getOrders(OrderDTO orderDTO) {
        List<OrderDTO> orders = orderService.findByCondition(orderDTO);
        return new ResponseEntity<>(ApiResult.success(orders), HttpStatus.OK);
    }
}
