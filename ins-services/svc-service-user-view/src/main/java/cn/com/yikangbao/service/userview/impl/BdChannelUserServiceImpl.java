package cn.com.yikangbao.service.userview.impl;

import cn.com.yikangbao.dao.userview.BdChannelUserDao;
import cn.com.yikangbao.entity.userview.BdChannelUser;
import cn.com.yikangbao.entity.userview.BdChannelUserDTO;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import cn.com.yikangbao.service.userview.BdChannelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BdChannelUserService")
public class BdChannelUserServiceImpl extends BaseServiceImpl<BdChannelUser, BdChannelUserDTO>  implements BdChannelUserService {
    @Autowired
    private BdChannelUserDao dao;

    @Autowired
    public void setDao(BdChannelUserDao dao) {
        this.dao = dao;
        super.setDAO(dao);
    }
}
