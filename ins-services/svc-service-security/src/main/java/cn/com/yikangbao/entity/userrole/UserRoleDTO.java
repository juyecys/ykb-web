package cn.com.yikangbao.entity.userrole;

import cn.com.yikangbao.entity.common.Page;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/18.
 */
@Alias("UserRoleQM")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRoleDTO extends UserRole implements Serializable {

    private static final long serialVersionUID = 5466369749929483612L;

    private String userName;

    private String userDescription;

    private String roleName;

    private String roleDescription;

    private Boolean roleIsActive;

    private String roleCode;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public Boolean getRoleIsActive() {
        return roleIsActive;
    }

    public void setRoleIsActive(Boolean roleIsActive) {
        this.roleIsActive = roleIsActive;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    @Override
    public String toString() {
        return "UserRoleDTO{" +
                "userName='" + userName + '\'' +
                ", userDescription='" + userDescription + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                ", roleIsActive=" + roleIsActive +
                ", roleCode='" + roleCode + '\'' +
                '}';
    }
}
