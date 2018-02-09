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

    @JsonProperty("text")
    private Text text;

    @JsonProperty("image")
    private Image image;

    @JsonProperty("voice")
    private Voice voice;

    @JsonProperty("video")
    private Video video;

    @JsonProperty("music")
    private Music music;

    @JsonProperty("articles")
    private List<Article> articles;

    @JsonProperty("mp_news")
    private Mpnews mpnews;

    @JsonProperty("wx_card")
    private Wxcard wxcard;

    private Integer sequence;

    public static enum MsgTypeEnum {
        IMAGE("image"),
        VOICE("voice"),
        VIDEO("video"),
        TEXT("text"),
        MUSIC("music"),
        NEWS("news"),
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

    public class Text {
        @JsonProperty("content")
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public class Image {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    public class Voice {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    public class Video {
        @JsonProperty("media_id")
        private String mediaId;
        @JsonProperty("thumb_media_id")
        private String thumbMediaId;
        @JsonProperty("title")
        private String title;
        @JsonProperty("description")
        private String description;

    }

    public class Music {
        @JsonProperty("title")
        private String title;
        @JsonProperty("description")
        private String description;
        @JsonProperty("music_url")
        private String musicUrl;
        @JsonProperty("hq_music_url")
        private String hqMusicUrl;
        @JsonProperty("thumb_media_id")
        private String thumbMediaId;

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

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
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

    public class Mpnews {
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    public class Wxcard {
        @JsonProperty("card_id")
        private String cardId;

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }
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

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public Mpnews getMpnews() {
        return mpnews;
    }

    public void setMpnews(Mpnews mpnews) {
        this.mpnews = mpnews;
    }

    public Wxcard getWxcard() {
        return wxcard;
    }

    public void setWxcard(Wxcard wxcard) {
        this.wxcard = wxcard;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", msgType='" + msgType + '\'' +
                ", text=" + text +
                ", image=" + image +
                ", voice=" + voice +
                ", video=" + video +
                ", music=" + music +
                ", articles=" + articles +
                ", mpnews=" + mpnews +
                ", wxcard=" + wxcard +
                ", sequence=" + sequence +
                '}';
    }
}
