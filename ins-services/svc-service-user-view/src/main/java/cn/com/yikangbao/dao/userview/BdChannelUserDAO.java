package cn.com.yikangbao.dao.userview;

import cn.com.yikangbao.dao.common.BaseDAO;
import cn.com.yikangbao.entity.userview.BdChannelUser;
import cn.com.yikangbao.entity.userview.BdChannelUserDTO;
import org.springframework.stereotype.Component;

/**
 * Created by jeysine on 2018/2/21.
 */
@Component
public interface BdChannelUserDAO extends BaseDAO<BdChannelUser, BdChannelUserDTO> {

    Integer exists(String phone);

    Integer existsUserId(String userId);
}
