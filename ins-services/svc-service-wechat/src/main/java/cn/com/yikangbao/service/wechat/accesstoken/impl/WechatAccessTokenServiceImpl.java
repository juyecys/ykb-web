package cn.com.yikangbao.service.wechat.accesstoken.impl;

import cn.com.yikangbao.config.wechat.WechatConfigSecret;
import cn.com.yikangbao.contants.wechat.WechatConfigParams;
import cn.com.yikangbao.entity.wechat.acesstoken.WechatAccessToken;
import cn.com.yikangbao.service.wechat.accesstoken.WechatAccessTokenService;
import cn.com.yikangbao.untils.common.okhttputil.OkHttpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.UUID;

@Service("wechatAccessTokenService")
public class WechatAccessTokenServiceImpl implements WechatAccessTokenService {


	@Autowired
	private JedisPool jedisPool;

	private static Logger logger = LoggerFactory.getLogger(WechatAccessTokenServiceImpl.class);

	private static final ObjectMapper mapper = new ObjectMapper();

	@Override
	public WechatAccessToken getAccessToken() {
		WechatAccessToken wechatAccessToken = null;
		Jedis jedis = jedisPool.getResource();
		if (jedis == null) {
			logger.error("Redis is not rechable");
		}

		try {
			do {
				Long accessTokenExpired = jedis.ttl(WechatConfigParams.ACCESS_TOKEN_KEY);
				String accessToken = jedis.get(WechatConfigParams.ACCESS_TOKEN_KEY);

				if (accessToken != null && accessTokenExpired > 0) {
					wechatAccessToken =  new WechatAccessToken(accessToken, accessTokenExpired);
					logger.debug("get access token from redis success, access token:{} expired:{}",accessToken,accessTokenExpired);
				} else {
					//logger.debug("Redis is not exists access token , start get lock to get access token from wechat.");
					String mutexKeyValue = UUID.randomUUID().toString();
					if (isLeader(jedis, mutexKeyValue)) {
						wechatAccessToken = getAccessTokenFromWechat();
					}
				}
			} while (wechatAccessToken == null);
		} finally {
			jedis.close();
		}
		return wechatAccessToken;
	}
	private Boolean isLeader(Jedis jedis, String mutexKeyValue) {
		Long mutexKeyExpired = 10L;
		String existsMutexKeyValue = jedis.get(WechatConfigParams.ACCESS_TOKEN_KEY_MUTEX);

		//防止某线程或进程第一次获得leader但获取或设置accessToken失败而进行第二次设置
		if (existsMutexKeyValue != null && mutexKeyValue.equals(existsMutexKeyValue)) {
			logger.debug("set access token not need lock");
			return true;
		} else if (existsMutexKeyValue != null){
			logger.debug("get leader faild");
			return false;
		}

		String result = jedis.set(WechatConfigParams.ACCESS_TOKEN_KEY_MUTEX, mutexKeyValue, "NX", "EX", mutexKeyExpired);
		if (result != null) {
			logger.debug("get leader success");
			return true;
		} else {
			logger.debug("get leader faild");
		}
		return false;
	}

	private WechatAccessToken getAccessTokenFromWechat()  {
		String url = WechatConfigParams.WECHAT_GET_ACCESSTOKEN_URL.replace("APPID", WechatConfigSecret.getWechatAppid())
				.replace("APPSECRET", WechatConfigSecret.getWechatSecret());

		Response response = null;
		WechatAccessToken wechatAccessToken = null;
		try {
			response = OkHttpUtils.get().url(url)
					.build().execute();

			String result = response.body().string();
			wechatAccessToken = mapper.readValue(result, WechatAccessToken.class);
			logger.debug("get wechat access token suucess:{}", wechatAccessToken);
			if (wechatAccessToken.getAccessToken() == null) {
				logger.error("get wechat access token error, errcode:{},errmsg:{}", wechatAccessToken.getErrcode(),wechatAccessToken.getErrmsg());
				return null;
			}

			wechatAccessToken.setExpiresIn(
					wechatAccessToken.getExpiresIn());
			logger.debug("get wechat access token suucess:{}", wechatAccessToken.getAccessToken());
			setAccessTokenToRedis(wechatAccessToken);
		} catch (IOException e) {
			logger.error("visit wechat get access token faild:{}", e);
		}


		return wechatAccessToken;
	}

	private void setAccessTokenToRedis(WechatAccessToken accessToken) throws IOException {
		logger.debug("set access token to redis start.");
		Jedis jedis = jedisPool.getResource();
		Long accessTokenExpiredIn = accessToken.getExpiresIn() - 5L;
		if (accessTokenExpiredIn < 0) {
			return;
		}
		String result = jedis.set(WechatConfigParams.ACCESS_TOKEN_KEY, accessToken.getAccessToken(), "NX", "EX", accessTokenExpiredIn);
		logger.debug("result:{}",result);
		if (result != null) {
			logger.debug("set access token to redis success, accessToken:{}, expired: {}.", accessToken.getAccessToken(),accessToken.getExpiresIn());
			jedis.del(WechatConfigParams.ACCESS_TOKEN_KEY_MUTEX);
		} else {
			logger.debug("access token had saved.");
		}
	}
	public static void main(String[] args) {
		/*String url = "https://api.weixin.qq.com/cgi-bin/token";
		try {
			Response response = OkHttpUtils.get().url(url)
					.addParams("grant_type","client_credential")
					.addParams("appid","wx51e37306f30d52a9")
					.addParams("secret","07f0af046496ce6d6e5bc8f98ec75f65")
					.build().execute();
			WechatAccessToken wechatAccessToken = null;
			wechatAccessToken = mapper.readValue(response.body().string(), WechatAccessToken.class);
			System.out.println(wechatAccessToken);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		Long s = System.currentTimeMillis()/1000;
		System.out.println(s);
	}
}
