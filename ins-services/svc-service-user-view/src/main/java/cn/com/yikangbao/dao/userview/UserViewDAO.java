package cn.com.yikangbao.dao.userview;

import cn.com.yikangbao.dao.common.BaseDAO;
import cn.com.yikangbao.entity.userview.BdChannelUserDTO;
import cn.com.yikangbao.entity.userview.UserView;
import org.springframework.stereotype.Component;

/**
 * Created by jeysine on 2018/2/21.
 */
@Component
public interface UserViewDAO extends BaseDAO<UserView, BdChannelUserDTO> {
}
