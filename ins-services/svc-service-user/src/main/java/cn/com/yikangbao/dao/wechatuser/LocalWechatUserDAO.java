package cn.com.yikangbao.dao.wechatuser;

import cn.com.yikangbao.dao.common.BaseDAO;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUser;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUserDTO;
import org.springframework.stereotype.Component;

/**
 * Created by jeysine on 2018/1/24.
 */
@Component
public interface LocalWechatUserDAO extends BaseDAO<LocalWechatUser, LocalWechatUserDTO> {

}
