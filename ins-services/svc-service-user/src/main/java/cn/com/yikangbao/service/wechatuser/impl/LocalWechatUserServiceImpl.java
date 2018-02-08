package cn.com.yikangbao.service.wechatuser.impl;

import cn.com.yikangbao.dao.wechatuser.LocalWechatUserDAO;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUser;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUserDTO;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import cn.com.yikangbao.service.wechatuser.LocalWechatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jeysine on 2018/1/24.
 */
@Service("localWechatUserService")
public class LocalWechatUserServiceImpl extends BaseServiceImpl<LocalWechatUser, LocalWechatUserDTO> implements LocalWechatUserService {
    @Autowired
    private LocalWechatUserDAO dao;

    @Autowired
    private void setDao(LocalWechatUserDAO dao) {
        this.dao = dao;
        super.setDAO(dao);
    }
}
