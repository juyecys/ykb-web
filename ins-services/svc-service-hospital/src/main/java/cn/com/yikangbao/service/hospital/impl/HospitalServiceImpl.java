package cn.com.yikangbao.service.hospital.impl;

import cn.com.yikangbao.dao.hospital.HospitalDAO;
import cn.com.yikangbao.entity.hospital.Hospital;
import cn.com.yikangbao.entity.hospital.HospitalDTO;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import cn.com.yikangbao.service.hospital.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jeysine on 2018/2/5.
 */
@Service("hospitalService")
public class HospitalServiceImpl extends BaseServiceImpl<Hospital, HospitalDTO> implements HospitalService {
    @Autowired
    private HospitalDAO  dao;

    @Autowired
    public void setDao(HospitalDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }

    @Override
    public List<HospitalDTO> findForPartner(HospitalDTO hospitalDTO) {
        return dao.findForPartner(hospitalDTO);
    }
}
