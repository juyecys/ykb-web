package cn.com.yikangbao.entity.user;

import cn.com.yikangbao.entity.common.Page;

import java.io.Serializable;

public class UserDTO extends User implements Serializable {
    private static final long serialVersionUID = 3930220600362884579L;

    private String roleId;

    private String roleName;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
