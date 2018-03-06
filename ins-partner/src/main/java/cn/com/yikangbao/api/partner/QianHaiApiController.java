package cn.com.yikangbao.api.partner;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.config.partner.PartnerSecretKeyConfig;
import cn.com.yikangbao.entity.hospital.HospitalDTO;
import cn.com.yikangbao.entity.order.Order;
import cn.com.yikangbao.entity.orderrecord.OrderRecord;
import cn.com.yikangbao.entity.qianhai.QianHaiActionType;
import cn.com.yikangbao.entity.qianhai.QianHaiHospital;
import cn.com.yikangbao.entity.qianhai.QianHaiOrder;
import cn.com.yikangbao.entity.questionnaire.Questionnaire;
import cn.com.yikangbao.exception.partner.PartnerException;
import cn.com.yikangbao.service.hospital.HospitalService;
import cn.com.yikangbao.service.order.OrderService;
import cn.com.yikangbao.service.orderrecord.OrderRecordService;
import cn.com.yikangbao.service.partner.qianhai.QianhaiService;
import cn.com.yikangbao.untils.common.DateUtils;
import cn.com.yikangbao.untils.common.MapUtils;
import cn.com.yikangbao.untils.common.okhttputil.OkHttpUtils;
import cn.com.yikangbao.utils.partner.PartnerConvertUtils;
import cn.com.yikangbao.utils.partner.PartnerSignUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = { "/ykb/partner/qianhai" }, produces = "application/json")
public class QianHaiApiController {

    @Autowired
    private QianhaiService qianhaiService;

    @Autowired
    private HospitalService hospitalService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRecordService orderRecordService;

    private String qianhaiOrderStatusUrl="http://wxsaleuat.qhins.com/wcthl/third/entry/ykb/tubebaby/orderStatus/";

    private static final Logger logger = LoggerFactory.getLogger(QianHaiApiController.class);
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ApiResult createOrder(@RequestBody QianHaiOrder qianHaiOrder) throws PartnerException {
        logger.info("receive qianhai order: {}", qianHaiOrder);

        if (qianHaiOrder == null) {
            throw new PartnerException(PartnerException.PartnerErrorCode.ERROR_PARAMETER);
        }

        String[] needParams = new String[]{
                "sign","proposerName","proposerCredentialsType","proposerCredentialsNum","proposerPhone"
                ,"insuredName","insuredCredentialsType","insuredCredentialsNum","insuredPhone","relation"
                ,"hospitalId","hospitalName","insuranceAmount","orderAmount","questionnaireList"
                ,"orderNumber","orderDate","userId","status","insuranceStartDate","insuranceEndDate"
        };

        try {
            HashMap<String, Object> data = MapUtils.getMap(qianHaiOrder, QianHaiOrder.class);

            if (data == null) {
                logger.error("partner order map is empty\n\n");
                throw new PartnerException(PartnerException.PartnerErrorCode.ERROR);
            }
            String secretKey = PartnerSecretKeyConfig.getQianhaiSecretKey();
            PartnerSignUtils.verifyPartnerRequest(data, secretKey, needParams);
        } catch (IllegalAccessException e) {
            logger.error("transfer param missing: {}\n\n", e);
        } catch (PartnerException e) {
            logger.error("error code: {}, error msg: {}, exception: {}", e.getErrorCode().getCode(), e.getErrorCode().getDesc(), e);
            throw e;
        }

        qianhaiService.createOrderByPartner(qianHaiOrder);

        return ApiResult.success();
    }

    @RequestMapping(value = "/order/update", method = RequestMethod.POST)
    public ApiResult updateOrder(@RequestBody QianHaiOrder qianHaiOrder) throws PartnerException {
        logger.info("receive qianhai order: {}", qianHaiOrder);
        String[] needParams = new String[]{
                "sign","proposerName","proposerCredentialsType","proposerCredentialsNum","proposerPhone"
                ,"insuredName","insuredCredentialsType","insuredCredentialsNum","insuredPhone","relation"
                ,"hospitalId","hospitalName","insuranceAmount","orderAmount","questionnaireList"
                ,"orderNumber","orderDate","userId","status","insuranceStartDate","insuranceEndDate"
        };
        updatePartnerOrder(qianHaiOrder, needParams);

        return ApiResult.success();
    }

    @RequestMapping(value = "/order/status", method = RequestMethod.POST)
    public ApiResult updateOrderStatus(@RequestBody QianHaiOrder qianHaiOrder) throws PartnerException {
        logger.info("receive qianhai order: {}", qianHaiOrder);
        String[] needParams = new String[]{
                "sign","orderNumber","status","statusDate"
        };
        updatePartnerOrder(qianHaiOrder, needParams);

        return ApiResult.success();
    }
    @RequestMapping(value = "/hospital", method = RequestMethod.GET)
    public ApiResult findHospital(QianHaiHospital qianHaiHospital) throws PartnerException {
        logger.info("receive qianhai qianHaiHospital: {}", qianHaiHospital);
        String[] needParams = new String[]{
                "sign"
        };
        HashMap<String, Object> data = null;
        try {
            data = MapUtils.getMap(qianHaiHospital, QianHaiHospital.class);
            if (data == null) {
                logger.error("partner order map is empty\n\n");
                throw new PartnerException(PartnerException.PartnerErrorCode.ERROR);
            }
            String secretKey = PartnerSecretKeyConfig.getQianhaiSecretKey();
            PartnerSignUtils.verifyPartnerRequest(data, secretKey, needParams);
        } catch (IllegalAccessException e) {
            logger.error("transfer param missing: {}\n\n", e);
        } catch (PartnerException e) {
            logger.error("error code: {}, error msg: {}, exception: {}", e.getErrorCode().getCode(), e.getErrorCode().getDesc(), e);
            throw e;
        }
        List<HospitalDTO> hospitalDTOList = hospitalService.findForPartner(new HospitalDTO());
        //logger.info("hospital: {}", hospitalDTOList);
        return ApiResult.success(hospitalDTOList);
    }

    private void updatePartnerOrder(QianHaiOrder qianHaiOrder, String[] needParams) throws PartnerException {
        if (qianHaiOrder == null) {
            throw new PartnerException(PartnerException.PartnerErrorCode.ERROR_PARAMETER);
        }

        try {
            HashMap<String, Object> data = MapUtils.getMap(qianHaiOrder, QianHaiOrder.class);
            if (data == null) {
                logger.error("partner order map is empty\n\n");
                throw new PartnerException(PartnerException.PartnerErrorCode.ERROR);
            }

            String secretKey = PartnerSecretKeyConfig.getQianhaiSecretKey();
            PartnerSignUtils.verifyPartnerRequest(data, secretKey, needParams);
        } catch (IllegalAccessException e) {
            logger.error("transfer param missing: {}", e);
        } catch (PartnerException e) {
            logger.error("error code: {}, error msg: {}, exception: {}", e.getErrorCode().getCode(), e.getErrorCode().getDesc(), e);
            throw e;
        }
        qianhaiService.updateOrderByPartner(qianHaiOrder);
    }

    @RequestMapping(value = "/order/getStatus", method = RequestMethod.GET)
    public ApiResult getOrderStatus(QianHaiOrder qianHaiOrder) throws Exception {
        logger.info("receive qianhai order: {}", qianHaiOrder);

        HashMap<String, Object> data = new HashMap<>();
        data.put("orderId", qianHaiOrder.getOrderNumber());
        data.put("reqTime", DateUtils.format(new Date(), "yyyyMMddHHmmss"));
        data.put("actionType", QianHaiActionType.ENTRY.getValue());
        String sign = PartnerSignUtils.getSign(data, PartnerSecretKeyConfig.getQianhaiSecretKeyFor());
        data.put("sign", sign);

        ObjectMapper mapper = new ObjectMapper();
        String dataJson = mapper.writeValueAsString(data);
        logger.debug("start to synchronous qianhai order status: {}, url:{}", dataJson,qianhaiOrderStatusUrl);
        String resultJson = OkHttpUtils.postString().url(qianhaiOrderStatusUrl).content(dataJson).build().execute().body().string();
        logger.debug("synchronous qianhai order status result: {}", resultJson);
        HashMap resultMap = mapper.readValue(resultJson, HashMap.class);
        Order newOrder = PartnerConvertUtils.convertOrder(resultMap);
        OrderRecord orderRecord = null;
        orderService.synchronousOrderStatus(newOrder);
        orderRecord = new OrderRecord();
        orderRecord.setOrderNumber(newOrder.getOrderNumber());
        orderRecord.setStatus(newOrder.getStatus());
        orderRecordService.createOrUpdate(orderRecord);

        return ApiResult.success(newOrder);
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("proposerName", "李晓明");
        hashMap.put("proposerCredentialsType", "IdCard");
        hashMap.put("proposerCredentialsNum", "4458278492452245834582");
        hashMap.put("proposerPhone", "132432542345");
        hashMap.put("insuredName", "李晓明");
        hashMap.put("insuredCredentialsType", "IdCard");
        hashMap.put("insuredCredentialsNum", "4458278492452245834582");
        hashMap.put("insuredPhone", "132432542345");

        String key = "f8786021b9b54825bc0dd5d8423c4c9c";

        /*Questionnaire必须复写toString, 详细请见Questionnaire toString方法*/
        List<Questionnaire> questionnaireList = new LinkedList<>();
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setAnswer("<0.5");
        questionnaire.setId("dfwekjfknblkafmgrge");
        questionnaireList.add(questionnaire);
        questionnaireList.add(questionnaire);
        hashMap.put("questionnaireList", questionnaireList);

        QianHaiOrder qianHaiOrder = (QianHaiOrder) MapUtils.getObject(hashMap, QianHaiOrder.class, MapUtils.FirstOneCaseEnum.LOWER);
        System.out.println(qianHaiOrder);

        HashMap hashMap1 = MapUtils.getMap(qianHaiOrder, QianHaiOrder.class);
        MapUtils.filterPageForMap(hashMap1);
        System.out.println(hashMap1);
    }
}
