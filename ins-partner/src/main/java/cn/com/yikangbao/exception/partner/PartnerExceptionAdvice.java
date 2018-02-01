package cn.com.yikangbao.exception.partner;

import cn.com.yikangbao.api.common.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
