package cn.com.yikangbao.service.channelgroup.impl;

import cn.com.yikangbao.dao.channelgroup.ChannelGroupDAO;
import cn.com.yikangbao.entity.channelgroup.ChannelGroup;
import cn.com.yikangbao.entity.channelgroup.ChannelGroupDTO;
import cn.com.yikangbao.service.channelgroup.ChannelGroupService;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by jeysine on 2018/2/21.
 */
@Service("channelGroupService")
public class ChannelGroupServiceImpl extends BaseServiceImpl<ChannelGroup, ChannelGroupDTO> implements ChannelGroupService {
    private ChannelGroupDAO dao;

    public void setDao(ChannelGroupDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }
}
