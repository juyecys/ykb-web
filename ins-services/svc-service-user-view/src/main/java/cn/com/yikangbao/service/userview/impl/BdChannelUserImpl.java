package cn.com.yikangbao.service.userview.impl;

import cn.com.yikangbao.dao.userview.BdChannelUserDao;
import cn.com.yikangbao.entity.userview.UserView;
import cn.com.yikangbao.entity.userview.UserViewDTO;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import cn.com.yikangbao.service.userview.BdChannelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BdChannelUserService")
public class BdChannelUserImpl extends BaseServiceImpl<UserView, UserViewDTO>  implements BdChannelUserService {
    @Autowired
    private BdChannelUserDao dao;

    @Autowired
    public void setDao(BdChannelUserDao dao) {
        this.dao = dao;
        super.setDAO(dao);
    }
}
