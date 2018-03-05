package cn.com.yikangbao.entity.menu;

import cn.com.yikangbao.entity.common.Base;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * Created by jeysine on 2018/1/23.
 */
@Alias("MenuM")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Menu extends Base {
    private String name;

    private String code;

    private Integer sequence;

    private Boolean isParentMenu;

    private String resourceId;

    private String resrouce;

    private String parentMenuCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Boolean getParentMenu() {
        return isParentMenu;
    }

    public void setParentMenu(Boolean parentMenu) {
        isParentMenu = parentMenu;
    }

    public String getParentMenuCode() {
        return parentMenuCode;
    }

    public void setParentMenuCode(String parentMenuCode) {
        this.parentMenuCode = parentMenuCode;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getResrouce() {
        return resrouce;
    }

    public void setResrouce(String resrouce) {
        this.resrouce = resrouce;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", sequence=" + sequence +
                ", isParentMenu=" + isParentMenu +
                ", resourceId='" + resourceId + '\'' +
                ", resrouce='" + resrouce + '\'' +
                ", parentMenuCode='" + parentMenuCode + '\'' +
                '}';
    }
}