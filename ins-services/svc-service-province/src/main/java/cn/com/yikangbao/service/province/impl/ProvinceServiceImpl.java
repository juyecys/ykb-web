package cn.com.yikangbao.service.province.impl;

import cn.com.yikangbao.dao.province.ProvinceDAO;
import cn.com.yikangbao.entity.province.Province;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import cn.com.yikangbao.service.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jeysine on 2018/3/14.
 */
@Service("provinceService")
public class ProvinceServiceImpl extends BaseServiceImpl<Province, Province> implements ProvinceService{
    @Autowired
    private ProvinceDAO dao;

    @Autowired
    public void setDao(ProvinceDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }
}
