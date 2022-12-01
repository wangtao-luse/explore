package com.explore.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class ObjectRedisTemplate {
	@Autowired
private RedisTemplate<String, Object> objRedisTemplate;
	/**
	 * 存放为Hash
	 * @param key
	 * @param hashKey
	 * @param value
	 * @return
	 */
	public  boolean hashPut(String key,String hashKey,Object value) {
		try {
			objRedisTemplate.opsForHash().put(key, hashKey, value);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	/**
	 * 获取Hash
	 * @param key
	 * @param hashKey
	 * @return
	 */	
	public Object hashGet(String key,String hashKey) {
		return objRedisTemplate.opsForHash().get(key, hashKey);
	}
	/**
	 * 删除hash
	 * @param key
	 * @param hashKeys
	 * @return
	 */
	public  boolean hashDel(String key,Object... hashKeys) {
		try {
			objRedisTemplate.opsForHash().delete(key, hashKeys);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	
}
