package cn.com.yikangbao.entity.qianhai;

import cn.com.yikangbao.entity.order.Order;
import cn.com.yikangbao.entity.questionnaire.Questionnaire;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

/**
 * Created by jeysine on 2018/2/1.
 * 用于与第三发交互
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class QianHaiOrder extends Order {

    private String sign;

    private List<Questionnaire> questionnaireList;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date statusDate;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public List<Questionnaire> getQuestionnaireList() {
        return questionnaireList;
    }

    public void setQuestionnaireList(List<Questionnaire> questionnaireList) {
        this.questionnaireList = questionnaireList;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    @Override
    public String toString() {
        return super.toString() + "PartnerOrder{" +
                "sign='" + sign + '\'' +
                ", questionnaireList=" + questionnaireList +
                ", statusDate=" + statusDate +
                '}';
    }
}
