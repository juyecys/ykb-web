package cn.com.yikangbao.entitys.authority;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/17.
 */
public class Resource implements Serializable {
    private static final long serialVersionUID = 9107301064993142032L;

    private String id ;
    private String name;
    private String type;
    private String resource;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", resource='" + resource + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
