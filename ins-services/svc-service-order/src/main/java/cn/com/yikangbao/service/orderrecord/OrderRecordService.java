package cn.com.yikangbao.service.orderrecord;

import cn.com.yikangbao.entity.orderrecord.OrderRecord;
import cn.com.yikangbao.entity.orderrecord.OrderRecordDTO;
import cn.com.yikangbao.service.common.BaseService;

import java.util.List;

/**
 * Created by jeysine on 2018/2/5.
 */
public interface OrderRecordService extends BaseService<OrderRecord, OrderRecordDTO> {
    List<OrderRecordDTO> findNeedNotifyOrder(OrderRecordDTO orderRecordDTO);
}
