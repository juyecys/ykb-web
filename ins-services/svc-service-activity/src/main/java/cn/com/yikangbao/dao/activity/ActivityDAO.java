package cn.com.yikangbao.dao.activity;

import cn.com.yikangbao.dao.common.BaseDAO;
import cn.com.yikangbao.entity.activity.Activity;
import cn.com.yikangbao.entity.activity.ActivityDTO;
import org.springframework.stereotype.Component;

/**
 * Created by jeysine on 2018/2/21.
 */
@Component
public interface ActivityDAO extends BaseDAO<Activity, ActivityDTO> {
}
