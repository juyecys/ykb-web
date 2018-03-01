package cn.com.yikangbao.service.wechatuser.impl;

import cn.com.yikangbao.dao.wechatuser.LocalWechatUserDAO;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUser;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUserDTO;
import cn.com.yikangbao.service.common.impl.BaseServiceImpl;
import cn.com.yikangbao.service.wechatuser.LocalWechatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 获取未与微信同步的用户
     * @return
     */
    @Override
    public List<LocalWechatUserDTO> findByUnsynchronous() {
        return dao.findByUnsynchronous();
    }

    @Override
    public void synchronousUser(LocalWechatUser wechatUser) {
        dao.synchronousUser(wechatUser);
    }

    @Override
    public Integer countUsers(LocalWechatUserDTO wechatUser) {
        return dao.countUsers(wechatUser);
    }
}
