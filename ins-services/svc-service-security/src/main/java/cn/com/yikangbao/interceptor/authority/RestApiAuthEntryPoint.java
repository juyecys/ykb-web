package cn.com.yikangbao.interceptor.authority;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class RestApiAuthEntryPoint implements AuthenticationEntryPoint {

	private static Logger logger = LoggerFactory.getLogger(RestApiAuthEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		logger.trace("{} is entered the entry point.", request.getRequestURL());
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("{\"code\":\"4001\",\"desc\":\"权限不足，请联系管理员!\"}");
		out.flush();
		out.close();
		//response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}
}
