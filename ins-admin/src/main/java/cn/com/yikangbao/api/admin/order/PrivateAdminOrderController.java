package cn.com.yikangbao.api.admin.order;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.common.Page;
import cn.com.yikangbao.entity.order.Order;
import cn.com.yikangbao.entity.order.OrderDTO;
import cn.com.yikangbao.service.order.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jeysine on 2018/3/13.
 */
@RestController
@RequestMapping(value = { "/ykb/mg/private/order", "/ykb/mg/public/order" }, produces = "application/json")
public class PrivateAdminOrderController {
    private static Logger logger = LoggerFactory.getLogger(PrivateAdminOrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> getPage(@RequestBody OrderDTO order) {
        Page<OrderDTO> page = orderService.findByConditionPage(order);
        return new ResponseEntity<>(ApiResult.success(page), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> update(@RequestBody Order order) throws Exception {
        order = orderService.createOrUpdate(order);
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        order = orderService.findOneByCondition(orderDTO);
        return new ResponseEntity<>(ApiResult.success(order), HttpStatus.OK);
    }
}
