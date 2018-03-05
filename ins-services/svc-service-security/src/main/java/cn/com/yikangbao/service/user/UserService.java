package cn.com.yikangbao.service.user;


import cn.com.yikangbao.entity.user.User;
import cn.com.yikangbao.entity.user.UserDTO;
import cn.com.yikangbao.service.common.BaseService;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by Administrator on 2018/1/17.
 */
public interface UserService extends  BaseService<User, UserDTO>, UserDetailsService {
}
