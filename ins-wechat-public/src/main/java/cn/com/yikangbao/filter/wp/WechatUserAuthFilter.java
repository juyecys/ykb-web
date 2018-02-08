package cn.com.yikangbao.filter.wp;

import cn.com.yikangbao.contants.wp.WechatPublicContants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jeysine on 2018/2/7.
 * 微信用户身份验证
 */
public class WechatUserAuthFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(WechatUserAuthFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if (req.getSession().getAttribute(WechatPublicContants.SESSION_OPENID) == null) {
            PrintWriter out = resp.getWriter();
            out.write("{\"code\":\"4001\",\"desc\":\"权限不足，请联系管理员!\"}");
            out.flush();
            out.close();
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
