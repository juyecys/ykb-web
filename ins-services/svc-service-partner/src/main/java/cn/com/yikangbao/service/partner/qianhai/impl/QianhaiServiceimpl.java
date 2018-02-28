package cn.com.yikangbao.service.partner.qianhai.impl;

import cn.com.yikangbao.entity.order.Order;
import cn.com.yikangbao.entity.orderrecord.OrderRecord;
import cn.com.yikangbao.entity.partner.PartnerOrder;
import cn.com.yikangbao.entity.qianhai.QianHaiOrder;
import cn.com.yikangbao.entity.questionnaire.Questionnaire;
import cn.com.yikangbao.exception.QianHaiException;
import cn.com.yikangbao.service.orderrecord.OrderRecordService;
import cn.com.yikangbao.untils.common.okhttputil.OkHttpUtils;
import cn.com.yikangbao.utils.partner.PartnerOrderUtils;
import cn.com.yikangbao.service.order.OrderService;
import cn.com.yikangbao.service.partner.qianhai.QianhaiService;
import cn.com.yikangbao.service.questionnaire.QuestionnaireService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
    private static String QIAN_HAI_INSURE_URL;

    @Value("${qianhai.order.get.detail}")
    private static String QIAN_HAI_GET_ORDER_URL;

    private static final ObjectMapper mapper = new ObjectMapper();

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

    @Override
    public void sendOrder(QianHaiOrder insure) throws IOException, QianHaiException {
        String insureJson = mapper.writeValueAsString(insure);
        logger.debug("qian hai insure data:{}", insureJson);
        OkHttpUtils.postString().url(QIAN_HAI_INSURE_URL).content(insureJson).build().execute();
       /* logger.debug("qian hai insure result:{}", result);
        CommonQianHai commonQianHai =  mapper.readValue(result,CommonQianHai.class);
        if (commonQianHai.getCode() != QianHaiException.QianHaiErrorCode.SUCCESS.getCode()) {
            logger.error("qianhai error, error code:{}, error desc: {}", commonQianHai.getCode(), commonQianHai.getDesc());
            throw new QianHaiException(commonQianHai.getCode(), commonQianHai.getDesc());
        }
        return commonQianHai;*/
    }

    @Override
    public void getOrderDetail(QianHaiOrder order) throws IOException, QianHaiException {
        String insureJson = mapper.writeValueAsString(order);
        logger.debug("qian hai order detail data:{}", insureJson);
        OkHttpUtils.postString().url(QIAN_HAI_INSURE_URL).content(insureJson).build().execute();
        /*logger.debug("qian hai order detail result:{}", result);
        CommonQianHai commonQianHai =  mapper.readValue(result,CommonQianHai.class);
        if (commonQianHai.getCode() != QianHaiException.QianHaiErrorCode.SUCCESS.getCode()) {
            logger.error("qianhai error, error code:{}, error desc: {}", commonQianHai.getCode(), commonQianHai.getDesc());
            throw new QianHaiException(commonQianHai.getCode(), commonQianHai.getDesc());
        }
        return commonQianHai;*/
    }

    private void createOrderRecord(Order order) {
        OrderRecord orderRecord = new OrderRecord();
        orderRecord.setOrderNumber(order.getOrderNumber());
        orderRecord.setStatus(order.getStatus());
        orderRecordService.create(orderRecord);
    }
}
