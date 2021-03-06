package cn.com.yikangbao.entity.questionnaire;

import cn.com.yikangbao.entity.common.Base;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.ibatis.type.Alias;

/**
 * Created by jeysine on 2018/2/1.
 */
@Alias("QuestionnaireM")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class Questionnaire extends Base{
    /**
     * 答案
     */
    @JsonProperty("answer")
    private String answer;

    /**
     * 订单id
     */
    @JsonProperty("order_id")
    private String orderId;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    @Override
    public String toString() {
        return "Questionnaire{" +
                "answer='" + answer + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
