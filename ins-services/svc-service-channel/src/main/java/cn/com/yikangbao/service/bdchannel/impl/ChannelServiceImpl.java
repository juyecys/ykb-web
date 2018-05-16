package cn.com.yikangbao.service.bdchannel.impl;

import cn.com.yikangbao.dao.bdchannel.ChannelDAO;
import cn.com.yikangbao.entity.bdchannel.Channel;
import cn.com.yikangbao.entity.bdchannel.ChannelDTO;
import cn.com.yikangbao.service.bdchannel.ChannelService;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("channelService")
public class ChannelServiceImpl extends BaseServiceImpl<Channel, ChannelDTO> implements ChannelService{
    @Autowired
    private ChannelDAO dao;

    @Autowired
    public void setDao(ChannelDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }
}
