package cn.com.yikangbao.entity.roleresource;

import cn.com.yikangbao.entity.common.Base;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/18.
 */
public class RoleResource extends Base implements Serializable {
    private static final long serialVersionUID = 3398623423650797577L;

    private String roleId;
    private String resourceId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public String toString() {
        return "RoleResource{" +
                "roleId='" + roleId + '\'' +
                ", resourceId='" + resourceId + '\'' +
                '}';
    }
}
