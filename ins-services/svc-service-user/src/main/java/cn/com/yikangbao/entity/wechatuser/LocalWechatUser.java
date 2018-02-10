package cn.com.yikangbao.entity.wechatuser;

import cn.com.yikangbao.entity.common.Base;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.ibatis.type.Alias;

/**
 * Created by jeysine on 2018/1/24.
 */
@Alias("LocalWechatUserM")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LocalWechatUser extends Base{
    private String openId;
    private String name;
    @JsonProperty("qr_code_scene")
    private String qrCodeScene;

    /**
     * 0表示用户没有关注该公众号,1表示有
     */
    @JsonProperty("subscribe")
    private Integer subscribe;

    @JsonProperty("nick_name")
    private String nickname;

    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    @JsonProperty("gender")
    private Integer gender;
    /**
     * 用户的语言
     */
    @JsonProperty("language")
    private String language;
    @JsonProperty("city")
    private String city;
    @JsonProperty("province")
    private String province;
    @JsonProperty("country")
    private String country;
    /**
     * 用户头像
     */
    @JsonProperty("head_img_url")
    private String headImgUrl;
    /**
     * 公众号绑定到微信开放平台,才有该字段
     */
    @JsonProperty("union_id")
    private String unionId;
    @JsonProperty("remark")
    private String remark;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQrCodeScene() {
        return qrCodeScene;
    }

    public void setQrCodeScene(String qrCodeScene) {
        this.qrCodeScene = qrCodeScene;
    }

    public Integer getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Integer subscribe) {
        this.subscribe = subscribe;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "LocalWechatUser{" +
                "openId='" + openId + '\'' +
                ", name='" + name + '\'' +
                ", qrCodeScene='" + qrCodeScene + '\'' +
                ", subscribe=" + subscribe +
                ", nickname='" + nickname + '\'' +
                ", gender=" + gender +
                ", language='" + language + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                ", unionId='" + unionId + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
