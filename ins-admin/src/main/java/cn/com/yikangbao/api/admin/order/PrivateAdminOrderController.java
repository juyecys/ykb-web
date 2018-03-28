package cn.com.yikangbao.api.admin.order;

import cn.com.yikangbao.api.common.ApiCodes;
import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.entity.common.Page;
import cn.com.yikangbao.entity.order.Order;
import cn.com.yikangbao.entity.order.OrderDTO;
import cn.com.yikangbao.entity.orderrecord.OrderRecord;
import cn.com.yikangbao.entity.orderrecord.OrderRecordDTO;
import cn.com.yikangbao.service.order.OrderService;
import cn.com.yikangbao.service.orderrecord.OrderRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * Created by jeysine on 2018/3/13.
 */
@RestController
@RequestMapping(value = { "/ykb/mg/private/order", "/ykb/mg/public/order" }, produces = "application/json")
public class PrivateAdminOrderController {
    private static Logger logger = LoggerFactory.getLogger(PrivateAdminOrderController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRecordService orderRecordService;

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> getPage(@RequestBody OrderDTO order) {
        Page<OrderDTO> page = orderService.findByConditionPage(order);
        return new ResponseEntity<>(ApiResult.success(page), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ApiResult> update(@RequestBody Order order) throws Exception {
        if (Objects.isNull(order.getId())) {
            return new ResponseEntity<>(ApiResult.build(ApiCodes.STATUS_INVALID_PARAMETER, "订单id不能为空"), HttpStatus.OK);
        }
        order = orderService.createOrUpdate(order);
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        order = orderService.findOneByCondition(orderDTO);
        return new ResponseEntity<>(ApiResult.success(order), HttpStatus.OK);
    }

    @RequestMapping(value = "/record", method = RequestMethod.GET)
    public ResponseEntity<ApiResult> getRecord(OrderRecordDTO orderRecord) {
        if (Objects.isNull(orderRecord.getOrderNumber())) {
            return new ResponseEntity<>(ApiResult.build(ApiCodes.STATUS_INVALID_PARAMETER, "订单号不能为空"), HttpStatus.OK);
        }
        List<OrderRecordDTO> list = orderRecordService.findByCondition(orderRecord);
        return new ResponseEntity<>(ApiResult.success(list), HttpStatus.OK);
    }
}
