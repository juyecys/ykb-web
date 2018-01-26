package cn.com.yikangbao.untils.wechat;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 请求校验工具类
 *
 * @author liufeng
 * @date 2013-09-01
 */
public class WechatSignUtil {
	private static Logger logger = LoggerFactory.getLogger(WechatSignUtil.class);

	private static String YKB_TOKEN;
	private static String IOT_TOKEN;

	/**
	 * 校验微信公众号设备事件推送签名
	 *
	 * @param signature
	 *            微信加密签名
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机数
	 * @return
	 */
	public static boolean checkIOTMessageSignature(String signature, String timestamp, String nonce) {
		return checkMessageSignature(signature, IOT_TOKEN, timestamp, nonce);
	}

	/**
	 * 校验易康保微信公众号推送签名
	 *
	 * @param signature
	 *            微信加密签名
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机数
	 * @return
	 */
	public static boolean checkUserMessageSignature(String signature, String timestamp, String nonce) {
		return checkMessageSignature(signature, YKB_TOKEN, timestamp, nonce);
	}

	/**
	 * 校验签名
	 *
	 * @param signature
	 *            微信加密签名
	 * @param token
	 *            微信公众平台配置的对应token
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机数
	 * @return
	 */
	public static boolean checkMessageSignature(String signature, String token, String timestamp, String nonce) {
		try {
			// 对token、timestamp和nonce按字典排序
			String[] paramArr = new String[] { token, timestamp, nonce };
			Arrays.sort(paramArr);

			// 将排序后的结果拼接成一个字符串
			String content = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);

			String ciphertext = null;
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-1");
				// 对接后的字符串进行sha1加密
				byte[] digest = md.digest(content.toString().getBytes());
				ciphertext = byteToStr(digest);
			} catch (NoSuchAlgorithmException e) {
				logger.error("Check wechat push message signature is failed", e);
			}

			// 将sha1加密后的字符串与signature进行对比
			return ciphertext != null ? ciphertext.equals(signature.toUpperCase()) : false;
		} catch (Exception e) {
			logger.error("Check wechat push message signature is failed", e);
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 将字节数组转换为十六进制字符串
	 *
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}

	/**
	 * 将字节转换为十六进制字符串
	 *
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];

		String s = new String(tempArr);
		return s;
	}

	public void setYKB_TOKEN(String YKB_TOKEN) {
		WechatSignUtil.YKB_TOKEN = YKB_TOKEN;
	}

	public void setIOT_TOKEN(String IOT_TOKEN) {
		WechatSignUtil.IOT_TOKEN = IOT_TOKEN;
	}
}
