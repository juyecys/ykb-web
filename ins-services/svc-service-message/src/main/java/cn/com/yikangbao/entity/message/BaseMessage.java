package cn.com.yikangbao.entity.message;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jeysine on 2018/3/27.
 */
public class BaseMessage implements Serializable {
    private static final long serialVersionUID = -4557066193167992003L;

    public enum TypeEnum {
        CHANNEL,
        SUBSCRIBE
    }

    public enum MsgTypeEnum {
        IMAGE("image"),
        VOICE("voice"),
        VIDEO("video"),
        TEXT("text"),
        MUSIC("music"),
        ARTICLE_LIST("article_list"),
        ARTICLE("article"),
        MPNEWS("mpnews"),
        WXCARD("wxcard"),
        TEMPLATE("template");

        private String value;

        MsgTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static MsgTypeEnum getEnumByValue(String value) {
            for (MsgTypeEnum e: MsgTypeEnum.values()) {
                if (e.getValue().equals(value)) {
                    return e;
                }
            }
            return null;
        }
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @JsonProperty("created_date")
    private Date createdDate;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @JsonProperty("updated_date")
    private Date updatedDate;

    @JsonProperty("updated_by")
    private String updatedBy;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
