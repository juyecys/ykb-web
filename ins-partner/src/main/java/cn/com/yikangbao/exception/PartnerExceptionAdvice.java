package cn.com.yikangbao.exception;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.exception.partner.PartnerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class PartnerExceptionAdvice {

    private Logger logger = LoggerFactory.getLogger(PartnerExceptionAdvice.class);

    @ExceptionHandler({PartnerException.class})
    @ResponseBody
    public ApiResult handlePartnerException(PartnerException e) {
        return new ApiResult(e.getErrorCode().getCode(), e.getErrorCode().getDesc());
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ApiResult handleException(Exception e) {
        logger.debug("error: {}", e);
        PartnerException.PartnerErrorCode errorCode = PartnerException.PartnerErrorCode.ERROR;
        return new ApiResult(errorCode.getCode(), errorCode.getDesc());
    }
}
