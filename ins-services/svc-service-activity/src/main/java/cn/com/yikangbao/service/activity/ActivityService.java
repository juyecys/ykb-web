package cn.com.yikangbao.service.activity;

import cn.com.yikangbao.entity.activity.Activity;
import cn.com.yikangbao.entity.activity.ActivityDTO;
import cn.com.yikangbao.service.common.BaseService;

public interface ActivityService extends BaseService<Activity, ActivityDTO> {
    Activity selectByName(String name);
}
