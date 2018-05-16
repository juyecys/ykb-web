package cn.com.yikangbao.service.channel.impl;

import cn.com.yikangbao.dao.channel.BdChannelDAO;
import cn.com.yikangbao.entity.channel.BdChannel;
import cn.com.yikangbao.entity.channel.BdChannelDTO;
import cn.com.yikangbao.service.channel.BdChannelService;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BdChannelService")
public class BdChannelServiceImpl extends BaseServiceImpl<BdChannel, BdChannelDTO> implements BdChannelService{
    @Autowired
    private BdChannelDAO dao;

    @Autowired
    public void setDao(BdChannelDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }
}
