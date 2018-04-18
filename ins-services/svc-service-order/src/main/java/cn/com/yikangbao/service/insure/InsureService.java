package cn.com.yikangbao.service.insure;

import cn.com.yikangbao.entity.insure.Insure;
import cn.com.yikangbao.entity.insure.InsureDTO;
import cn.com.yikangbao.service.common.BaseService;

import java.util.List;

/**
 * Created by jeysine on 2018/2/26.
 */
public interface InsureService extends BaseService<Insure, InsureDTO> {
    List<String> getAllSource();
}
