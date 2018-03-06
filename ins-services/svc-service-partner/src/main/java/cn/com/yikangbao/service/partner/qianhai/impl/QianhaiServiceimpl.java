package cn.com.yikangbao.service.partner.qianhai.impl;

import cn.com.yikangbao.config.partner.PartnerSecretKeyConfig;
import cn.com.yikangbao.entity.order.Order;
import cn.com.yikangbao.entity.order.OrderDTO;
import cn.com.yikangbao.entity.orderrecord.OrderRecord;
import cn.com.yikangbao.entity.qianhai.QianHaiOrder;
import cn.com.yikangbao.entity.questionnaire.Questionnaire;
import cn.com.yikangbao.service.order.OrderService;
import cn.com.yikangbao.service.orderrecord.OrderRecordService;
import cn.com.yikangbao.service.partner.qianhai.QianhaiService;
import cn.com.yikangbao.service.questionnaire.QuestionnaireService;
import cn.com.yikangbao.untils.common.DateUtils;
import cn.com.yikangbao.untils.common.okhttputil.OkHttpUtils;
import cn.com.yikangbao.utils.partner.PartnerConvertUtils;
import cn.com.yikangbao.utils.partner.PartnerOrderUtils;
import cn.com.yikangbao.utils.partner.PartnerSignUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
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

    @Value("${qianhai.order.get.status}")
    private String qianhaiOrderStatusUrl;

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
        orderService.synchronousOrderStatus(order);
        List<Questionnaire> questionnaireList = qianHaiOrder.getQuestionnaireList();
        logger.debug("update questionnaireList: {}", questionnaireList);
        if (questionnaireList != null) {
            questionnaireService.updateByList(questionnaireList);
        }
        createOrderRecord(order);

    }

    @Override
    public void synchronousOrderStatus() {
        List<OrderDTO> orders =  orderService.findNeedSysByStatus();
        logger.info("need synchronous order: {}", orders);
        Order newOrder = null;
        OrderRecord orderRecord = null;
        HashMap<String, Object> data = new HashMap<>();
        if (!orders.isEmpty()) {
            for (OrderDTO order: orders) {
                try {
                    data.put("orderId", order.getOrderNumber());
                    data.put("reqTime", DateUtils.format(new Date(), "yyyyMMddHHmmss"));
                    String sign = PartnerSignUtils.getSign(data, PartnerSecretKeyConfig.getQianhaiSecretKeyFor());
                    data.put("sign", sign);
                    String dataJson = mapper.writeValueAsString(data);
                    logger.debug("start to synchronous qianhai order status: {}", dataJson);
                    String resultJson = OkHttpUtils.postString().url(qianhaiOrderStatusUrl).content(dataJson).build().execute().body().string();
                    logger.debug("synchronous qianhai order status result: {}", resultJson);
                    HashMap resultMap = mapper.readValue(resultJson, HashMap.class);
                    newOrder = PartnerConvertUtils.convertOrder(resultMap);
                    if (!order.getStatus().equals(newOrder.getStatus())) {
                        orderService.synchronousOrderStatus(newOrder);
                        orderRecord = new OrderRecord();
                        orderRecord.setOrderNumber(newOrder.getOrderNumber());
                        orderRecord.setStatus(newOrder.getStatus());
                        orderRecordService.createOrUpdate(orderRecord);
                    }
                } catch (Exception e) {
                    logger.error("", e);
                }

            }

        }
    }


    private void createOrderRecord(Order order) {
        OrderRecord orderRecord = new OrderRecord();
        orderRecord.setOrderNumber(order.getOrderNumber());
        orderRecord.setStatus(order.getStatus());
        orderRecordService.create(orderRecord);
    }
}
