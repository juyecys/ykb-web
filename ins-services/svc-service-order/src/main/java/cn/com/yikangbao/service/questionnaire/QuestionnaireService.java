package cn.com.yikangbao.service.questionnaire;

import cn.com.yikangbao.entity.order.Order;
import cn.com.yikangbao.entity.questionnaire.Questionnaire;
import cn.com.yikangbao.service.common.BaseService;

import java.util.List;

/**
 * Created by jeysine on 2018/2/1.
 */
public interface QuestionnaireService extends BaseService<Questionnaire, Questionnaire>{
    void createByList(List<Questionnaire> list, Order order);
    void updateByList(List<Questionnaire> list);
}
