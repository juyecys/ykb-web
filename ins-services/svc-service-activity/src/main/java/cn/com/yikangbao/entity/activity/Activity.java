package cn.com.yikangbao.entity.activity;

import cn.com.yikangbao.entity.common.Base;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Activity extends Base {

    private String name;

    private String banners;

    private String imgs;

    private String kefu;

    private String email;

    private String ex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBanners() {
        return banners;
    }

    public void setBanners(String banners) {
        this.banners = banners;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getKefu() {
        return kefu;
    }

    public void setKefu(String kefu) {
        this.kefu = kefu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }


    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", banners='" + banners + '\'' +
                ", imgs='" + imgs + '\'' +
                ", kefu='" + kefu + '\'' +
                ", email='" + email + '\'' +
                ", ex='" + ex + '\'' +
                '}';
    }
}
