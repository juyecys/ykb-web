package cn.com.yikangbao.dao.bdchannel;

import cn.com.yikangbao.dao.common.BaseDAO;
import cn.com.yikangbao.entity.bdchannel.BdChannel;
import cn.com.yikangbao.entity.bdchannel.BdChannelDTO;
import org.springframework.stereotype.Component;

/**
 * Created by jeysine on 2018/2/21.
 */
@Component
public interface BdChannelDAO extends BaseDAO<BdChannel, BdChannelDTO> {

    String getIdByCode(String channelsCode);
}
