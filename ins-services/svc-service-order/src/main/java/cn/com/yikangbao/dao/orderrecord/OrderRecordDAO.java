package cn.com.yikangbao.dao.orderrecord;

import cn.com.yikangbao.dao.common.BaseDAO;
import cn.com.yikangbao.entity.orderrecord.OrderRecord;
import cn.com.yikangbao.entity.orderrecord.OrderRecordDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jeysine on 2018/2/5.
 */
@Component
public interface OrderRecordDAO extends BaseDAO<OrderRecord, OrderRecordDTO>{
    List<OrderRecordDTO> findNeedNotifyOrder(OrderRecordDTO orderRecordDTO);
}
