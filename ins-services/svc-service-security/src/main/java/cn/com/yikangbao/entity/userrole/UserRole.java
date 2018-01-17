package cn.com.yikangbao.entity.userrole;

import cn.com.yikangbao.entity.common.Base;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/18.
 */
@Alias("UserRoleM")
public class UserRole extends Base implements Serializable{
    private static final long serialVersionUID = -2134894813801929734L;

    private String userId;
    private String roleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userId='" + userId + '\'' +
                ", roleId='" + roleId + '\'' +
                '}';
    }
}
