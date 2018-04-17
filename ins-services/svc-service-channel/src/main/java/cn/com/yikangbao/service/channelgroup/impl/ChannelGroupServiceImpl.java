package cn.com.yikangbao.service.channelgroup.impl;

import cn.com.yikangbao.dao.channelgroup.ChannelGroupDAO;
import cn.com.yikangbao.entity.channelgroup.ChannelGroup;
import cn.com.yikangbao.entity.channelgroup.ChannelGroupDTO;
import cn.com.yikangbao.service.channelgroup.ChannelGroupService;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import cn.com.yikangbao.untils.common.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jeysine on 2018/2/21.
 */
@Service("channelGroupService")
public class ChannelGroupServiceImpl extends BaseServiceImpl<ChannelGroup, ChannelGroupDTO> implements ChannelGroupService {
    @Autowired
    private ChannelGroupDAO dao;

    @Autowired
    public void setDao(ChannelGroupDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }

    @Override
    public ChannelGroup createOrUpdate(ChannelGroup entity) throws Exception {
        if (entity.getId() == null) {
            ChannelGroupDTO channelGroup = new ChannelGroupDTO();
            channelGroup.setName(entity.getName());
            channelGroup = findOneByCondition(channelGroup);
            if (channelGroup == null) {
                throw new Exception("分组名不能重复");
            }
            entity.setScene(StringUtil.numRandom(6));
            return create(entity);
        }

        return update(entity);
    }
}
