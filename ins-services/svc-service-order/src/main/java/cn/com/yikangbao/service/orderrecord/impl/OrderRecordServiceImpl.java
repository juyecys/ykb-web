package cn.com.yikangbao.service.orderrecord.impl;

import cn.com.yikangbao.dao.orderrecord.OrderRecordDAO;
import cn.com.yikangbao.entity.orderrecord.OrderRecord;
import cn.com.yikangbao.entity.orderrecord.OrderRecordDTO;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import cn.com.yikangbao.service.orderrecord.OrderRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jeysine on 2018/2/5.
 */
@Service("orderRecordService")
public class OrderRecordServiceImpl extends BaseServiceImpl<OrderRecord, OrderRecordDTO> implements OrderRecordService {

    @Autowired
    private OrderRecordDAO dao;

    @Autowired
    public void setDao(OrderRecordDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }

    @Override
    public List<OrderRecordDTO> findNeedNotifyOrder(OrderRecordDTO orderRecordDTO) {
        return dao.findNeedNotifyOrder(orderRecordDTO);
    }
}
