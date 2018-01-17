package cn.com.yikangbao.dao.userrole;

import cn.com.yikangbao.dao.common.BaseDAO;
import cn.com.yikangbao.entity.userrole.UserRole;
import cn.com.yikangbao.entity.userrole.UserRoleDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2018/1/18.
 */
@Component
public interface UserRoleDAO extends BaseDAO<UserRole, UserRoleDTO>{
    List<UserRoleDTO> findRolesByUserId(@Param("userId") String userId);
    List<UserRoleDTO> findByCondition(UserRoleDTO userRoleDTO);

}
