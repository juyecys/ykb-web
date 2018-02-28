package cn.com.yikangbao.exception;

/**
 * Created by jeysine on 2018/2/28.
 */
public class QianHaiException extends Exception{
    public static enum  QianHaiErrorCode {
        SUCCESS("2000", "成功"),
        ERROR("5000", "系统错误"),
        SIGN_ERROR("5001", "签名错误"),
        PARAMTER_ERROR("5002", "参数错误"),
        ORDER_NOT_FOUND("5003", "订单不存在"),
        IDCARD_ERROR("5004", "身份证号码不正确"),
        PHONE_ERROR("5005", "手机号码不正确");

        private String code;

        private String desc;

        QianHaiErrorCode(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    private QianHaiErrorCode errorCode;

    public QianHaiException() {
    }

    public QianHaiException(String code, String desc) {
        super(desc);
        for (QianHaiErrorCode one: QianHaiErrorCode.values()) {
            if (one.getCode().equals(code)) {
                this.errorCode = one;
                break;
            }
        }
    }

    public QianHaiException(QianHaiErrorCode errorCode) {
        super(errorCode.getDesc());
        this.errorCode = errorCode;
    }

    public QianHaiException(QianHaiErrorCode errorCode, Exception e) {
        super(e);
        this.errorCode = errorCode;
    }
    public QianHaiException(QianHaiErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public QianHaiException(String message) {
        super(message);
    }

    public QianHaiException(Throwable cause) {
        super(cause);
    }

    public QianHaiException(String message, Throwable cause) {
        super(message, cause);
    }

    public QianHaiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public QianHaiErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(QianHaiErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
