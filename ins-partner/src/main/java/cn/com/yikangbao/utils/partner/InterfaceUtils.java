package cn.com.yikangbao.utils.partner;

import cn.com.yikangbao.untils.common.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 接口通用工具类
 */
public class InterfaceUtils {

	private static Logger log = LoggerFactory.getLogger(InterfaceUtils.class);

	/**
	 * 获取Request中的单个参数值
	 */
	public static String getRequestParam(HttpServletRequest request, String param) {
		try {
			String value = request.getParameter(param);
			if (value == null) {
				return null;
			}
			return URLDecoder.decode(value, "utf-8");
		} catch (Exception e) {
			log.error("url decode faild: ", e);
		}
		return null;
	}

	/**
	 * 获取Request中的单个参数值
	 */
	public static String getRequestGbkParam(HttpServletRequest request, String param) {
		try {
			String value = request.getParameter(param);
			if (value == null) {
				return null;
			}
			return URLDecoder.decode(value, "GBK");
		} catch (Exception e) {
			log.error("url decode faild:", e);
		}
		return null;
	}

	/**
	 * 获取Request中的参数名和参数值的Map集合
	 */
	private static SortedMap<String, String> getRequestParams(HttpServletRequest request) {
		String regEx = "(\\?|&+)(.+?)=([^&]*)"; // 匹配参数名和参数值的正则表达式
		String url = request.getRequestURL() + "?" + request.getQueryString();
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(url);
		SortedMap<String, String> paramMap = new TreeMap<String, String>();
		while (m.find()) {
			try {
				String paramName = m.group(2); // 获取参数名
				String paramVal = URLDecoder.decode(m.group(3), "utf-8"); // 获取参数值
				paramMap.put(paramName, paramVal);
			} catch (Exception e) {
				log.error("url decode faild:", e);
			}
		}
		return paramMap;
	}

	/**
	 * 验证接口请求是否合法
	 *
	 * @param request
	 *            用于获取请求参数
	 *            返回给接口的结果对象
	 * @param params
	 *            接口必填的参数数组
	 * @param SECRET_KEY
	 *            分配给接口的秘钥
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("rawtypes")
	public static Boolean verifyRequest(HttpServletRequest request, String[] params,
											String SECRET_KEY) throws UnsupportedEncodingException {
		// 验证必填参数
		for (String param : params) {
			String paramValue = request.getParameter(param);
			if (StringUtils.isEmpty(paramValue)) {
				log.warn("invalid param - {} : {}", param, paramValue);
				return false;
			}
		}
		// 获取参数验证签名
		SortedMap<String, String> requestParams = getRequestParams(request);
		log.trace("request params:" + requestParams);

		String paramSign = null;
		StringBuilder sb = new StringBuilder();
		Set es = requestParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			Object v =  entry.getValue();
			if (k.equals("sign")) {
				//paramSign = v;
				continue;
			}
			if (null != v && !"".equals(v)) {
				sb.append(k + v);
			}
		}
		sb.append(SECRET_KEY);

		log.debug("before sign:" + sb.toString());
		String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8").toLowerCase();
		log.debug("after sign:" + sign);

		if (!sign.equals(paramSign)) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String param = "%E6%B5%8B%E8%AF%95%E5%9B%9B";
		try {
			SortedMap<String, String> requestParams = new TreeMap<>();
			/*List<>
			requestParams.put("")*/
			Set es = requestParams.entrySet();
			Iterator it = es.iterator();
			StringBuilder sb = new StringBuilder();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				String k = (String) entry.getKey();
				String v = (String) entry.getValue();
				if (null != v && !"".equals(v)) {
					sb.append(k + v);
				}
			}

			String gbkParam = URLDecoder.decode(param, "GBK");
			String utf8Param = URLDecoder.decode(param, "utf-8");
			System.out.println("gbkParam:"+gbkParam);
			System.out.println("utf8Param:"+utf8Param);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
