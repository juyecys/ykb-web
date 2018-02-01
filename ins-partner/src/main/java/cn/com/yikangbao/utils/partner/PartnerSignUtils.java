package cn.com.yikangbao.utils.partner;

import cn.com.yikangbao.exception.partner.PartnerException;
import cn.com.yikangbao.untils.common.StringUtil;
import cn.com.yikangbao.utils.common.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by jeysine on 2018/2/1.
 */
public class PartnerSignUtils {
    private static final Logger logger = LoggerFactory.getLogger(PartnerSignUtils.class);

    public static String getSign(HashMap<String, Object> params, String secretKey) {
        SortedMap<String, Object> requestParams = new TreeMap<>(params);
        Set es = requestParams.entrySet();
        Iterator it = es.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue().toString();
            sb.append(k + v);
        }
        sb.append(secretKey);
        logger.debug("before md5: {}", sb.toString());
        String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toLowerCase();
        return sign;
    }

    public static Boolean verifyPartnerRequest(HashMap<String, Object> params, String secretKey, String[] needParams ) throws PartnerException {
        if (verifyNeedParam(params, needParams)) {
            return verifySign(
                    getSign(params, secretKey), (String) params.get("sign"));
        }
        throw new PartnerException(PartnerException.PartnerErrorCode.ERROR_PARAMETER);
    }

    private static Boolean verifySign(String selfSign, String partnerSign) throws PartnerException {
        logger.debug("partner sign: {}", partnerSign);
        logger.debug("self sign: {}", selfSign);
        if (StringUtil.isEmpty(partnerSign) || StringUtil.isEmpty(selfSign)) {
            throw new PartnerException(PartnerException.PartnerErrorCode.ERROR_SIGN);
        } else if (partnerSign.equals(selfSign)) {
            return true;
        }
        throw new PartnerException(PartnerException.PartnerErrorCode.ERROR_SIGN);
    }

    private static Boolean verifyNeedParam(HashMap<String, Object> params, String[] needParams) throws PartnerException {
        for (String needParam : needParams) {
            if (params.get(needParam) == null) {
                throw new PartnerException(PartnerException.PartnerErrorCode.ERROR_PARAMETER);
            }
        }
        return true;
    }

    public static void main(String[] args) {
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

        getSign(hashMap, key);
    }

    /*
    * 仅为该demo测试用
    * */
    public static class Questionnaire {
        private String id;
        private String answer;

        public Questionnaire() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        @Override
        public String toString() {
            return "{" +
                    "id='" + id + '\'' +
                    ", answer='" + answer + '\'' +
                    '}';
        }
    }
}
