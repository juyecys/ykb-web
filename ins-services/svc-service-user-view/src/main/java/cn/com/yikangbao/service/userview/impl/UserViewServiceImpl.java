package cn.com.yikangbao.service.userview.impl;

import cn.com.yikangbao.dao.userview.BdChannelUser;
import cn.com.yikangbao.entity.userview.UserView;
import cn.com.yikangbao.entity.userview.UserViewDTO;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import cn.com.yikangbao.service.userview.UserViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserViewService")
public class UserViewServiceImpl extends BaseServiceImpl<UserView, UserViewDTO>  implements UserViewService {
    @Autowired
    private BdChannelUser dao;

    @Autowired
    public void setDao(BdChannelUser dao) {
        this.dao = dao;
        super.setDAO(dao);
    }
}
