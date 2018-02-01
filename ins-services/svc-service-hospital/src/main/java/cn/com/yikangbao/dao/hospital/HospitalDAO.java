package cn.com.yikangbao.dao.hospital;

import cn.com.yikangbao.dao.common.BaseDAO;
import cn.com.yikangbao.entity.hospital.Hospital;
import cn.com.yikangbao.entity.hospital.HospitalDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jeysine on 2018/2/5.
 */
@Component
public interface HospitalDAO extends BaseDAO<Hospital, HospitalDTO>{
    List<HospitalDTO> findForPartner(HospitalDTO hospitalDTO);
}
