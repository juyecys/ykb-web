package cn.com.yikangbao.entity.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by jeysine on 2018/2/9.
 */
@Document(collection="ykb_message")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Message {
    @Id
    private String id;
    /**
     * 消息类型
     */
    @JsonProperty("msg_type")
    private String msgType;

    @JsonProperty("content")
    private String content;

    @JsonProperty("media_id")
    private String mediaId;

    @JsonProperty("thumb_media_id")
    private String thumbMediaId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;

    @JsonProperty("articles")
    private List<Article> articles;

    @JsonProperty("card_id")
    private String cardId;

    @JsonProperty("music_url")
    private String musicUrl;

    @JsonProperty("hq_music_url")
    private String hqMusicUrl;


    @JsonProperty("sequence")
    private Integer sequence;

    public static enum MsgTypeEnum {
        IMAGE("image"),
        VOICE("voice"),
        VIDEO("video"),
        TEXT("text"),
        MUSIC("music"),
        ARTICLE_LIST("article_list"),
        ARTICLE("article"),
        MPNEWS("mpnews"),
        WXCARD("wxcard");

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


    public class Article {
        @JsonProperty("title")
        private String title;
        @JsonProperty("description")
        private String description;
        @JsonProperty("url")
        private String url;
        @JsonProperty("pic_url")
        private String picUrl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }


    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getHqMusicUrl() {
        return hqMusicUrl;
    }

    public void setHqMusicUrl(String hqMusicUrl) {
        this.hqMusicUrl = hqMusicUrl;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", msgType='" + msgType + '\'' +
                ", content='" + content + '\'' +
                ", mediaId='" + mediaId + '\'' +
                ", thumbMediaId='" + thumbMediaId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", articles=" + articles +
                ", cardId='" + cardId + '\'' +
                ", musicUrl='" + musicUrl + '\'' +
                ", hqMusicUrl='" + hqMusicUrl + '\'' +
                ", sequence=" + sequence +
                '}';
    }
}
