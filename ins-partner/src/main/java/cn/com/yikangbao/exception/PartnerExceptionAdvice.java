package cn.com.yikangbao.exception;

import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.exception.partner.PartnerException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class PartnerExceptionAdvice {

    @ExceptionHandler({PartnerException.class})
    @ResponseBody
    public ApiResult handlePartnerException(PartnerException e) {
        return new ApiResult(e.getErrorCode().getCode(), e.getErrorCode().getDesc());
    }

}
