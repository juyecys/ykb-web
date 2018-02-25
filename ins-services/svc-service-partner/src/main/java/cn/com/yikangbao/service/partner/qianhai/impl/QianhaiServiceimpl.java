package cn.com.yikangbao.service.partner.qianhai.impl;

import cn.com.yikangbao.entity.order.Order;
import cn.com.yikangbao.entity.orderrecord.OrderRecord;
import cn.com.yikangbao.entity.partner.PartnerOrder;
import cn.com.yikangbao.entity.questionnaire.Questionnaire;
import cn.com.yikangbao.service.orderrecord.OrderRecordService;
import cn.com.yikangbao.utils.partner.PartnerOrderUtils;
import cn.com.yikangbao.service.order.OrderService;
import cn.com.yikangbao.service.partner.qianhai.QianhaiService;
import cn.com.yikangbao.service.questionnaire.QuestionnaireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("qianhaiService")
public class QianhaiServiceimpl implements QianhaiService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private OrderRecordService orderRecordService;

    private Logger logger = LoggerFactory.getLogger(QianhaiServiceimpl.class);
    @Override
    public void createOrderByPartner(PartnerOrder partnerOrder) {
        logger.debug("create partner order: {}", partnerOrder);
        Order order = PartnerOrderUtils.transformPartnerOrder(partnerOrder);
        order.setChannel(Order.ChannelEnum.QIAN_HAI.name());
        logger.debug("create order: {}", order);
        orderService.create(order);
        createOrderRecord(order);
        List<Questionnaire> questionnaireList = partnerOrder.getQuestionnaireList();
        logger.debug("create questionnaireList: {}", questionnaireList);
        questionnaireService.createByList(questionnaireList);
    }

    @Override
    public void updateOrderByPartner(PartnerOrder partnerOrder) {
        logger.debug("update partner order: {}", partnerOrder);
        Order order = PartnerOrderUtils.transformPartnerOrder(partnerOrder);
        logger.debug("update order: {}", order);
        orderService.update(order);
        List<Questionnaire> questionnaireList = partnerOrder.getQuestionnaireList();
        logger.debug("update questionnaireList: {}", questionnaireList);
        questionnaireService.updateByList(questionnaireList);
        createOrderRecord(order);

    }

    private void createOrderRecord(Order order) {
        OrderRecord orderRecord = new OrderRecord();
        orderRecord.setOrderNumber(order.getOrderNumber());
        orderRecord.setStatus(order.getStatus());
        orderRecordService.create(orderRecord);
    }
}
