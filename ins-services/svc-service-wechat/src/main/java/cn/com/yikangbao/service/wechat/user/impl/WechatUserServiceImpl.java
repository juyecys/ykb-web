package cn.com.yikangbao.service.wechat.user.impl;

import cn.com.yikangbao.dao.wechat.wechatuser.WechatUserDAO;
import cn.com.yikangbao.entity.wechat.wechatuser.WechatUser;
import cn.com.yikangbao.entity.wechat.wechatuser.WechatUserDTO;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import cn.com.yikangbao.service.wechat.user.WechatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jeysine on 2018/1/24.
 */
@Service("wechatUserService")
public class WechatUserServiceImpl extends BaseServiceImpl<WechatUser, WechatUserDTO> implements WechatUserService{
    @Autowired
    private WechatUserDAO dao;

    @Autowired
    private void setDao(WechatUserDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }
}
