package cn.com.yikangbao.service.insure.impl;

import cn.com.yikangbao.dao.insure.InsureDAO;
import cn.com.yikangbao.entity.insure.Insure;
import cn.com.yikangbao.entity.insure.InsureDTO;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import cn.com.yikangbao.service.insure.InsureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jeysine on 2018/2/26.
 */
@Service("insureService")
public class InsureServiceImpl extends BaseServiceImpl<Insure, InsureDTO> implements InsureService {
    @Autowired
    private InsureDAO dao;

    @Autowired
    public void setDao(InsureDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }

    @Override
    public List<String> getAllSource() {
        return dao.getAllSource();
    }
}
