package cn.com.yikangbao.service.channel.impl;

import cn.com.yikangbao.dao.channel.ChannelDAO;
import cn.com.yikangbao.entity.channel.Channel;
import cn.com.yikangbao.entity.channel.ChannelDTO;
import cn.com.yikangbao.service.channel.ChannelService;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
