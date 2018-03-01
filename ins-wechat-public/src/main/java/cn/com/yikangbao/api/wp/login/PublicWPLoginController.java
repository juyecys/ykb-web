package cn.com.yikangbao.api.wp.login;

import cn.com.yikangbao.contants.wp.WechatPublicContants;
import cn.com.yikangbao.entity.wechat.auth.WechatAuthAccessToken;
import cn.com.yikangbao.entity.wechatuser.LocalWechatUserDTO;
import cn.com.yikangbao.service.wechat.auth.WechatAuthService;
import cn.com.yikangbao.service.wechat.user.WechatUserService;
import cn.com.yikangbao.service.wechatuser.LocalWechatUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by jeysine on 2018/2/8.
 */
@RestController
@RequestMapping(value = { "/ykb/wp/public/login" }, produces = "application/json")
public class PublicWPLoginController {
    private static final Logger logger = LoggerFactory.getLogger(PublicWPLoginController.class);

    @Autowired
    private LocalWechatUserService localWechatUserService;

    @Autowired
    private WechatAuthService wechatAuthService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void login(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("code");
        StringBuilder nextYkbUrl = new StringBuilder(request.getParameter("ykb_url"));

        if (nextYkbUrl.toString().indexOf('?', 1) > -1) {
            // 其它的参数应该作为目标url的参数
            Enumeration<String> parameters = request.getParameterNames();
            while (parameters.hasMoreElements()) {
                String paramName = (String) parameters.nextElement();
                if (!paramName.equals("code") && !paramName.equals("ykb_url")) {
                    String[] values = request.getParameterValues(paramName);
                    nextYkbUrl.append("&").append(paramName).append("=").append(values[0]);
                }
            }
        }
        logger.debug("AuthWechat get wechat ykb_url {}", nextYkbUrl.toString());
        WechatAuthAccessToken wechatAuthAccessToken = null;
        try {
            wechatAuthAccessToken = wechatAuthService.getAuthAccessTokenByCode(code);
            LocalWechatUserDTO user = new LocalWechatUserDTO();
            user.setOpenId(wechatAuthAccessToken.getOpenId());
            user = localWechatUserService.findOneByCondition(user);
            logger.debug("user login success: {}", user.toString());
            request.getSession().setAttribute(WechatPublicContants.SESSION_OPENID, user.getOpenId());
            request.getSession().setAttribute(WechatPublicContants.SESSION_NICKNAME, user.getNickName());

            request.getSession().setAttribute(WechatPublicContants.SESSION_USERID, user.getId());
            request.getSession().setAttribute(WechatPublicContants.SESSION_UNIONID, user.getUnionId());
            response.sendRedirect(nextYkbUrl.toString());
        } catch (IOException e) {
            logger.debug("error: {}", e);
        }
    }
}
