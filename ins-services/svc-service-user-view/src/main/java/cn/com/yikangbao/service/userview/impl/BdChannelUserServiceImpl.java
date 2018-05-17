package cn.com.yikangbao.service.userview.impl;

import cn.com.yikangbao.dao.userview.BdChannelUserDAO;
import cn.com.yikangbao.entity.userview.BdChannelUser;
import cn.com.yikangbao.entity.userview.BdChannelUserDTO;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import cn.com.yikangbao.service.userview.BdChannelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BdChannelUserService")
public class BdChannelUserServiceImpl extends BaseServiceImpl<BdChannelUser, BdChannelUserDTO>  implements BdChannelUserService {
    @Autowired
    private BdChannelUserDAO dao;

    @Autowired
    public void setDao(BdChannelUserDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }
}
