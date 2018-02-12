package cn.com.yikangbao.jedis;

import redis.clients.jedis.Jedis;

public interface JedisCallback<T> {
	public T doWithJedis(Jedis jedis) throws JedisAccessException;
}
