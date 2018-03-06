package cn.com.yikangbao.service.questionnaire.impl;

import cn.com.yikangbao.dao.questionnaire.QuestionnaireDAO;
import cn.com.yikangbao.entity.questionnaire.Questionnaire;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import cn.com.yikangbao.service.questionnaire.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jeysine on 2018/2/1.
 */
@Service("questionnaireService")
public class QuestionnaireServiceImpl extends BaseServiceImpl<Questionnaire, Questionnaire> implements QuestionnaireService{
    @Autowired
    private QuestionnaireDAO dao;

    @Autowired
    public void setDao(QuestionnaireDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }

    @Override
    public void createByList(List<Questionnaire> list) {
        for (Questionnaire one: list) {
            create(one);
        }
    }

    @Override
    public void updateByList(List<Questionnaire> list) {
        dao.updateByList(list);
    }
}
