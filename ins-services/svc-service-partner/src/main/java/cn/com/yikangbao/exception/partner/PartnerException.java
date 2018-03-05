package cn.com.yikangbao.exception.partner;

public class PartnerException extends Exception{
    public static enum PartnerErrorCode {
        SUCCESS(2000, "success"),
        ERROR(5000, "系统繁忙，请稍后重试"),
        ERROR_SIGN(5001, "签名错误"),
        ERROR_PARAMETER(5002, "参数错误"),
        NOT_EXITST_ORDER(5003, "订单不存在"),
        ERROR_IDCARD(5004, "身份证号码不正确"),
        ERROR_PHONE_NUMBER(5005, "手机号码不正确");

        private int code;
        private String desc;

        PartnerErrorCode(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    private PartnerErrorCode errorCode;

    public PartnerException() {
    }
    public PartnerException(PartnerErrorCode errorCode) {
        super(errorCode.getDesc());
        this.errorCode = errorCode;
    }

    public PartnerException(PartnerErrorCode errorCode, Exception e) {
        super(e);
        this.errorCode = errorCode;
    }
    public PartnerException(PartnerErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public PartnerException(String message) {
        super(message);
    }

    public PartnerException(Throwable cause) {
        super(cause);
    }

    public PartnerException(String message, Throwable cause) {
        super(message, cause);
    }

    public PartnerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public PartnerErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(PartnerErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
