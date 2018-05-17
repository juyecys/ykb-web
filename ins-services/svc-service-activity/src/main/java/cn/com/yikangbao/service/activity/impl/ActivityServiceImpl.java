package cn.com.yikangbao.service.activity.impl;


import cn.com.yikangbao.dao.activity.ActivityDAO;
import cn.com.yikangbao.entity.activity.Activity;
import cn.com.yikangbao.entity.activity.ActivityDTO;
import cn.com.yikangbao.service.activity.ActivityService;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bdChannelService")
public class ActivityServiceImpl extends BaseServiceImpl<Activity, ActivityDTO> implements ActivityService {
    @Autowired
    private ActivityDAO dao;

    @Autowired
    public void setDao(ActivityDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }
}
