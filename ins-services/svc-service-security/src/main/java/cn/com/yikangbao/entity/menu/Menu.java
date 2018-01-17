package cn.com.yikangbao.entity.menu;

import cn.com.yikangbao.entity.common.Base;

import java.io.Serializable;

/**
 * Created by jeysine on 2018/1/23.
 */
public class Menu extends Base implements Serializable {
    private static final long serialVersionUID = 6740008433885100476L;

    private String menuName;

    private String menuCode;

    private String menuResource;

    private Integer sequence;

    private Boolean isParentMenu;

    private String parentMenuCode;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuResource() {
        return menuResource;
    }

    public void setMenuResource(String menuResource) {
        this.menuResource = menuResource;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}
