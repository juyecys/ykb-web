package cn.com.yikangbao.exception.wp;

import cn.com.yikangbao.api.common.ApiResult;
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
}
