package cn.com.yikangbao.entity.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by jeysine on 2018/3/27.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TemplateMessage extends BaseMessage implements Serializable {

    @JsonProperty("templateId")
    private String templateId;

    @JsonProperty("url")
    private String url;

    @JsonProperty("miniprogram")
    private String miniProgram;

    @JsonProperty("first")
    private String first;

    @JsonProperty("keyword1")
    private String keyword1;

    @JsonProperty("keyword2")
    private String keyword2;

    @JsonProperty("keyword3")
    private String keyword3;

    @JsonProperty("keyword4")
    private String keyword4;

    @JsonProperty("keyword5")
    private String keyword5;

    @JsonProperty("remark")
    private String remark;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1;
    }

    public String getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(String keyword2) {
        this.keyword2 = keyword2;
    }

    public String getKeyword3() {
        return keyword3;
    }

    public void setKeyword3(String keyword3) {
        this.keyword3 = keyword3;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMiniProgram() {
        return miniProgram;
    }

    public void setMiniProgram(String miniProgram) {
        this.miniProgram = miniProgram;
    }

    public String getKeyword4() {
        return keyword4;
    }

    public void setKeyword4(String keyword4) {
        this.keyword4 = keyword4;
    }

    public String getKeyword5() {
        return keyword5;
    }

    public void setKeyword5(String keyword5) {
        this.keyword5 = keyword5;
    }

    @Override
    public String toString() {
        return "TemplateMessage{" +
                ", templateId='" + templateId + '\'' +
                ", url='" + url + '\'' +
                ", miniProgram='" + miniProgram + '\'' +
                ", first='" + first + '\'' +
                ", keyword1='" + keyword1 + '\'' +
                ", keyword2='" + keyword2 + '\'' +
                ", keyword3='" + keyword3 + '\'' +
                ", keyword4='" + keyword4 + '\'' +
                ", keyword5='" + keyword5 + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
