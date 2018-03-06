package cn.com.yikangbao.service.partner.qianhai.impl;

import cn.com.yikangbao.entity.order.Order;
import cn.com.yikangbao.entity.orderrecord.OrderRecord;
import cn.com.yikangbao.entity.qianhai.QianHaiOrder;
import cn.com.yikangbao.entity.questionnaire.Questionnaire;
import cn.com.yikangbao.service.order.OrderService;
import cn.com.yikangbao.service.orderrecord.OrderRecordService;
import cn.com.yikangbao.service.partner.qianhai.QianhaiService;
import cn.com.yikangbao.service.questionnaire.QuestionnaireService;
import cn.com.yikangbao.utils.partner.PartnerOrderUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${qianhai.insure.url}")
    private String QIAN_HAI_INSURE_URL;

    @Value("${qianhai.order.get.detail}")
    private String QIAN_HAI_GET_ORDER_URL;

    private static final ObjectMapper mapper = new ObjectMapper();

    private Logger logger = LoggerFactory.getLogger(QianhaiServiceimpl.class);

    @Override
    public void createOrderByPartner(QianHaiOrder qianHaiOrder) {
        logger.debug("create partner order: {}", qianHaiOrder);
        Order order = PartnerOrderUtils.transformPartnerOrder(qianHaiOrder);
        order.setChannel(Order.ChannelEnum.QIAN_HAI.name());
        order.setName("试管婴儿保险");
        logger.debug("create order: {}", order);
        orderService.create(order);
        createOrderRecord(order);
        List<Questionnaire> questionnaireList = qianHaiOrder.getQuestionnaireList();
        logger.debug("create questionnaireList: {}", questionnaireList);
        questionnaireService.createByList(questionnaireList);
    }

    @Override
    public void updateOrderByPartner(QianHaiOrder qianHaiOrder) {
        logger.debug("update partner order: {}", qianHaiOrder);
        Order order = PartnerOrderUtils.transformPartnerOrder(qianHaiOrder);
        logger.debug("update order: {}", order);
        orderService.update(order);
        List<Questionnaire> questionnaireList = qianHaiOrder.getQuestionnaireList();
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
