package cn.com.yikangbao.exception.wp;

import cn.com.yikangbao.api.common.ApiCodes;
import cn.com.yikangbao.api.common.ApiResult;
import cn.com.yikangbao.exception.QianHaiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jeysine on 2018/2/8.
 */
@ControllerAdvice
public class WechatPublicExceptionAdvice {
    @ExceptionHandler({WechatPublicException.class})
    @ResponseBody
    public ApiResult handlePartnerException(WechatPublicException e) {
        return new ApiResult(e.getErrorCode().getCode(), e.getErrorCode().getDesc());
    }

    @ExceptionHandler({QianHaiException.class})
    @ResponseBody
    public ApiResult handlePartnerException(QianHaiException e) {
        return new ApiResult(Integer.parseInt(e.getErrorCode().getCode()), e.getErrorCode().getDesc());
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ApiResult handlePartnerException(Exception e) {
        return new ApiResult(ApiCodes.STATUS_UNKNOWN_ERROR, "系统错误");
    }
}
