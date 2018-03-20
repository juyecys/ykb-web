package cn.com.yikangbao.service.partner.qianhai.impl;

import cn.com.yikangbao.config.partner.PartnerSecretKeyConfig;
import cn.com.yikangbao.entity.insure.Insure;
import cn.com.yikangbao.entity.insure.InsureDTO;
import cn.com.yikangbao.entity.order.Order;
import cn.com.yikangbao.entity.order.OrderDTO;
import cn.com.yikangbao.entity.orderrecord.OrderRecord;
import cn.com.yikangbao.entity.qianhai.QianHaiGetOrderStatusReq;
import cn.com.yikangbao.entity.qianhai.QianHaiOrder;
import cn.com.yikangbao.entity.questionnaire.Questionnaire;
import cn.com.yikangbao.service.insure.InsureService;
import cn.com.yikangbao.service.order.OrderService;
import cn.com.yikangbao.service.orderrecord.OrderRecordService;
import cn.com.yikangbao.service.partner.qianhai.QianhaiService;
import cn.com.yikangbao.service.questionnaire.QuestionnaireService;
import cn.com.yikangbao.untils.common.DateUtils;
import cn.com.yikangbao.untils.common.IDCardUtils;
import cn.com.yikangbao.untils.common.MapUtils;
import cn.com.yikangbao.untils.common.StringUtil;
import cn.com.yikangbao.untils.common.okhttputil.OkHttpUtils;
import cn.com.yikangbao.utils.partner.PartnerSignUtils;
import cn.com.yikangbao.utils.partner.QianHaiOrderUtils;
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

    @Autowired
    private InsureService insureService;

    @Value("${qianhai.insure.url}")
    private String QIAN_HAI_INSURE_URL;

    @Value("${qianhai.order.get.detail}")
    private String QIAN_HAI_GET_ORDER_URL;

    @Value("${qianhai.order.get.status}")
    private String qianhaiOrderStatusUrl;

    private static final ObjectMapper mapper = new ObjectMapper();

    private Logger logger = LoggerFactory.getLogger(QianhaiServiceimpl.class);

    @Override
    public void createOrderByPartner(QianHaiOrder qianHaiOrder) throws Exception {
        logger.debug("create partner order: {}", qianHaiOrder);
        Order order = QianHaiOrderUtils.transformPartnerOrder(qianHaiOrder);
        order.setChannel(Order.ChannelEnum.QIAN_HAI.name());
        order.setName("试管婴儿保险");
        order.setOrderNumber(StringUtil.numRandom(12));
        order.setProposerAge(IDCardUtils.getAgeByIdCard(order.getProposerCredentialsNum()));
        order.setInsuredAge(IDCardUtils.getAgeByIdCard(order.getInsuredCredentialsNum()));
        order.setProposerGender(IDCardUtils.getGenderByIdCard(order.getProposerCredentialsNum()));
        order.setInsuredGender(IDCardUtils.getGenderByIdCard(order.getInsuredCredentialsNum()));
        logger.debug("create order: {}", order);
        order = orderService.createOrUpdate(order);
        createOrderRecord(order);
        List<Questionnaire> questionnaireList = qianHaiOrder.getQuestionnaireList();
        logger.debug("create questionnaireList: {}", questionnaireList);
        questionnaireService.createByList(questionnaireList, order);

        InsureDTO insureDTO = new InsureDTO();

        insureDTO.setUserId(order.getUserId());
        insureDTO = insureService.findOneByCondition(insureDTO);
        if (insureDTO.getOrderId() == null) {
            Insure insure = new Insure();
            insure.setId(insureDTO.getId());
            insure.setOrderId(order.getId());
            insure.setPartnerOrderId(order.getPartnerOrderId());
            insure.setOrderNumber(order.getOrderNumber());
            insureService.update(insure);
        }
    }

    @Override
    public void updateOrderByPartner(QianHaiOrder qianHaiOrder) throws Exception {
        logger.debug("update partner order: {}", qianHaiOrder);
        OrderDTO order = QianHaiOrderUtils.transformPartnerOrder(qianHaiOrder);
        logger.debug("update order: {}", order);
        orderService.update(order);
        List<Questionnaire> questionnaireList = qianHaiOrder.getQuestionnaireList();
        logger.debug("update questionnaireList: {}", questionnaireList);
        if (questionnaireList != null) {
            questionnaireService.updateByList(questionnaireList);
        }
        createOrderRecord(order);

    }

    @Override
    public void synchronousOrderStatus(List<OrderDTO> orders) {
        logger.info("need synchronous order: {}", orders);
        OrderDTO newOrder;
        HashMap<String, Object> data;
        if (!orders.isEmpty()) {
            QianHaiGetOrderStatusReq req = new QianHaiGetOrderStatusReq();
            for (OrderDTO order: orders) {
                try {
                    req.setOrderId(order.getPartnerOrderId());
                    req.setReqTime(DateUtils.format(new Date(), "yyyyMMddHHmmss"));
                    req.setUserId(order.getUserId());
                    data = MapUtils.getMap(req, QianHaiGetOrderStatusReq.class);
                    String sign = PartnerSignUtils.getSign(data, PartnerSecretKeyConfig.getQianhaiSecretKeyFor());
                    data.put("sign", sign);
                    String url = qianhaiOrderStatusUrl.replace("ACTION_TYPE", req.getActionType())
                            .replace("SIGN", sign).replace("ORDER_ID", req.getOrderId())
                            .replace("REQTIME", req.getReqTime()).replace("USER_ID", req.getUserId());
                    logger.debug("start to synchronous qianhai order status: {}", url);
                    String resultJson = OkHttpUtils.get().url(url).build().execute().body().string();
                    logger.debug("synchronous qianhai order status result: {}", resultJson);
                    HashMap resultMap = mapper.readValue(resultJson, HashMap.class);
                    newOrder = QianHaiOrderUtils.convertOrder(resultMap);
                    if (newOrder.getStatus() != null) {
                        newOrder.setStatus(QianHaiOrderUtils.transformQianHaiOrderStatus(newOrder.getStatus()));
                    }
                    if (newOrder.getStatus() != null && !order.getStatus().equals(newOrder.getStatus())) {
                        orderService.synchronousOrderStatus(newOrder);
                        createOrderRecord(newOrder);
                    }
                } catch (Exception e) {
                    logger.error("", e);
                }

            }

        }
    }


    private void createOrderRecord(Order order) throws Exception {
        if (order.getOrderNumber() == null) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setPartnerOrderId(order.getPartnerOrderId());
            order = orderService.findOneByCondition(orderDTO);
        }
        OrderRecord orderRecord = new OrderRecord();
        orderRecord.setOrderNumber(order.getOrderNumber());
        orderRecord.setStatus(order.getStatus());
        orderRecordService.createOrUpdate(orderRecord);
    }

}
