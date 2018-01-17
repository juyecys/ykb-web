package cn.com.yikangbao.interceptor.authority;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class RestAuthenticationSucessHandler extends SimpleUrlAuthenticationSuccessHandler {
	private final static Logger logger = LoggerFactory.getLogger(RestAuthenticationSucessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		logger.trace("Succeeded for auth {}", request.getRequestURL());
		clearAuthenticationAttributes(request);
	}
}
