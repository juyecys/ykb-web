package cn.com.yikangbao.service.wechatuser.impl;

import cn.com.yikangbao.dao.wechatuser.WechatUserDAO;
import cn.com.yikangbao.entity.wechatuser.WechatUser;
import cn.com.yikangbao.entity.wechatuser.WechatUserDTO;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import cn.com.yikangbao.service.wechatuser.WechatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jeysine on 2018/1/24.
 */
@Service("wechatUserService")
public class WechatUserServiceImpl extends BaseServiceImpl<WechatUser, WechatUserDTO> implements WechatUserService {
    @Autowired
    private WechatUserDAO dao;

    @Autowired
    private void setDao(WechatUserDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }
}
