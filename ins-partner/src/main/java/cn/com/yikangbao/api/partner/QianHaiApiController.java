package cn.com.yikangbao.api.partner;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.config.partner.PartnerSecretKeyConfig;
import cn.com.yikangbao.config.partner.ResultCode;
import cn.com.yikangbao.entity.hospital.Hospital;
import cn.com.yikangbao.entity.hospital.HospitalDTO;
import cn.com.yikangbao.entity.partner.PartnerOrder;
import cn.com.yikangbao.entity.questionnaire.Questionnaire;
import cn.com.yikangbao.exception.partner.PartnerException;
import cn.com.yikangbao.service.hospital.HospitalService;
import cn.com.yikangbao.service.partner.qianhai.QianhaiService;
import cn.com.yikangbao.untils.common.MapUtils;
import cn.com.yikangbao.utils.partner.PartnerSignUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = { "/partner/qianhai" }, produces = "application/json")
public class QianHaiApiController {

    @Autowired
    private QianhaiService qianhaiService;

    @Autowired
    private HospitalService hospitalService;

    private static final Logger logger = LoggerFactory.getLogger(QianHaiApiController.class);
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ApiResult createOrder(@RequestBody PartnerOrder partnerOrder) throws PartnerException {
        logger.info("receive qianhai order: {}", partnerOrder);

        if (partnerOrder == null) {
            throw new PartnerException(PartnerException.PartnerErrorCode.ERROR_PARAMETER);
        }

        String[] needParams = new String[]{
                "sign","proposerName","proposerCredentialsType","proposerCredentialsNum","proposerPhone"
                ,"insuredName","insuredCredentialsType","insuredCredentialsNum","insuredPhone","relation"
                ,"hosipitalId","hosipitalName","insuranceAmount","orderAmount","questionnaire"
                ,"orderNumber","createdDate","userId","status","insuranceStartDate","insuranceEndDate"
        };

        try {
            HashMap<String, Object> data = MapUtils.getMap(partnerOrder, PartnerOrder.class);

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

        qianhaiService.createOrderByPartner(partnerOrder);

        return ApiResult.success();
    }

    @RequestMapping(value = "/order/update", method = RequestMethod.POST)
    public ApiResult updateOrder(@RequestBody PartnerOrder partnerOrder) throws PartnerException {
        logger.info("receive qianhai order: {}", partnerOrder);
        String[] needParams = new String[]{
                "sign","proposerName","proposerCredentialsType","proposerCredentialsNum","proposerPhone"
                ,"insuredName","insuredCredentialsType","insuredCredentialsNum","insuredPhone","relation"
                ,"hosipitalId","hosipitalName","insuranceAmount","orderAmount","questionnaire"
                ,"orderNumber","createdDate","userId","status","insuranceStartDate","insuranceEndDate"
        };
        updatePartnerOrder(partnerOrder, needParams);

        return ApiResult.success();
    }

    @RequestMapping(value = "/order/status", method = RequestMethod.POST)
    public ApiResult updateOrderStatus(@RequestBody PartnerOrder partnerOrder) throws PartnerException {
        logger.info("receive qianhai order: {}", partnerOrder);
        String[] needParams = new String[]{
                "sign","orderNumber","status","statusDate"
        };
        updatePartnerOrder(partnerOrder, needParams);

        return ApiResult.success();
    }
    @RequestMapping(value = "/hospital", method = RequestMethod.GET)
    public ApiResult findHospital(@RequestBody HospitalDTO hospital) throws PartnerException {
        logger.info("receive qianhai hospital: {}", hospital);
        String[] needParams = new String[]{
                "sign"
        };
        HashMap<String, Object> data = null;
        try {
            data = MapUtils.getMap(hospital, PartnerOrder.class);
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
        List<HospitalDTO> hospitalDTOList = hospitalService.findForPartner(hospital);
        logger.info("hospital: {}", hospitalDTOList);
        return ApiResult.success(hospitalDTOList);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ApiResult test() throws PartnerException {
        List<Hospital> hospitals = new LinkedList<>();
        HospitalDTO hospital = new HospitalDTO();
        hospital.setProvinceName("广东省");
        hospital.setId("8c058c43-ccac-4070-a462-92e8418ab39d");
        hospital.setName("中医院");
        hospital.setPage(null);
        hospitals.add(hospital);
        hospitals.add(hospital);
        return ApiResult.build(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getDesc(), hospitals);
    }

    private void updatePartnerOrder(PartnerOrder partnerOrder, String[] needParams) throws PartnerException {
        if (partnerOrder == null) {
            throw new PartnerException(PartnerException.PartnerErrorCode.ERROR_PARAMETER);
        }

        try {
            HashMap<String, Object> data = MapUtils.getMap(partnerOrder, PartnerOrder.class);
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
        qianhaiService.updateOrderByPartner(partnerOrder);
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

        PartnerOrder partnerOrder = (PartnerOrder) MapUtils.getObject(hashMap, PartnerOrder.class, MapUtils.FirstOneCaseEnum.LOWER);
        System.out.println(partnerOrder);

        HashMap hashMap1 = MapUtils.getMap(partnerOrder, PartnerOrder.class);
        MapUtils.filterPageForMap(hashMap1);
        System.out.println(hashMap1);
    }
}
