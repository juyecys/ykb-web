package cn.com.yikangbao.service.activity.impl;

import cn.com.yikangbao.dao.activity.BdChannelDAO;
import cn.com.yikangbao.entity.activity.BdChannel;
import cn.com.yikangbao.entity.activity.BdChannelDTO;
import cn.com.yikangbao.service.activity.BdChannelService;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bdChannelService")
public class BdChannelServiceImpl extends BaseServiceImpl<BdChannel, BdChannelDTO> implements BdChannelService{
    @Autowired
    private BdChannelDAO dao;

    @Autowired
    public void setDao(BdChannelDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }
}
