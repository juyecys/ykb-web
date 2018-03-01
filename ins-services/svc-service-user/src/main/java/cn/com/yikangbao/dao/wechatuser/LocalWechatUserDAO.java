package cn.com.yikangbao.dao.wechatuser;

import cn.com.yikangbao.dao.common.BaseDAO;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUser;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUserDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jeysine on 2018/1/24.
 */
@Component
public interface LocalWechatUserDAO extends BaseDAO<LocalWechatUser, LocalWechatUserDTO> {
    List<LocalWechatUserDTO> findByUnsynchronous();
    void synchronousUser(LocalWechatUser wechatUser);
    Integer countUsers(LocalWechatUser wechatUser);
}
