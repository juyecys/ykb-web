package cn.com.yikangbao.dao.user;


import cn.com.yikangbao.dao.common.BaseDAO;
import cn.com.yikangbao.entity.user.User;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/1/17.
 */
@Component
public interface UserDAO extends BaseDAO<User, User> {
    User findOneByCondition(User user);
}
