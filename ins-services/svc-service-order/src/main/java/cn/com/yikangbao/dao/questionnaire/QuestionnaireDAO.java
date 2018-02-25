package cn.com.yikangbao.dao.questionnaire;

import cn.com.yikangbao.dao.common.BaseDAO;
import cn.com.yikangbao.entity.questionnaire.Questionnaire;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jeysine on 2018/2/1.
 */
@Component
public interface QuestionnaireDAO extends BaseDAO<Questionnaire, Questionnaire> {
    void createByList(List<Questionnaire> list);
    void updateByList(List<Questionnaire> list);
}
