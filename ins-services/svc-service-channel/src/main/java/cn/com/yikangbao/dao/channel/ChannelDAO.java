package cn.com.yikangbao.dao.channel;

import cn.com.yikangbao.dao.common.BaseDAO;
import cn.com.yikangbao.entity.channel.Channel;
import cn.com.yikangbao.entity.channel.ChannelDTO;
import cn.com.yikangbao.entity.channelgroup.ChannelGroup;
import cn.com.yikangbao.entity.channelgroup.ChannelGroupDTO;
import org.springframework.stereotype.Component;

/**
 * Created by jeysine on 2018/2/21.
 */
@Component
public interface ChannelDAO extends BaseDAO<Channel, ChannelDTO> {
}
