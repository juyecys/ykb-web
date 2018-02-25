package cn.com.yikangbao.service.hospital;

import cn.com.yikangbao.entity.hospital.Hospital;
import cn.com.yikangbao.entity.hospital.HospitalDTO;
import cn.com.yikangbao.service.common.BaseService;

import java.util.List;

/**
 * Created by jeysine on 2018/2/5.
 */
public interface HospitalService extends BaseService<Hospital, HospitalDTO> {
    List<HospitalDTO> findForPartner(HospitalDTO hospitalDTO);
}
