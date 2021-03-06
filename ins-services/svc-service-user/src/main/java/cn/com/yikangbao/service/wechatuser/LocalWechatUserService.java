package cn.com.yikangbao.service.wechatuser;


import cn.com.yikangbao.entity.wechatuser.LocalWechatUser;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUserDTO;
import cn.com.yikangbao.service.common.BaseService;

import java.util.List;

/**
 * Created by jeysine on 2018/1/24.
 */
public interface LocalWechatUserService extends BaseService<LocalWechatUser, LocalWechatUserDTO> {
    List<LocalWechatUserDTO> findByUnsynchronous();
    void synchronousUser(LocalWechatUser wechatUser);
}
