package com.explore.member.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.explore.common.leader.SysUser;
import com.explore.common.redis.ObjectRedisTemplate;
@SpringBootTest
public class TestRedis {
	/**
	 * redisTemplate:把k，v 经过了序列化存到redis。 k，v 是序列化的内容， 不能直接识别.默认使用的jdk序列化.
	 * 
	 */
	@Autowired
	RedisTemplate redisTemplate;
	/**
	 * stringRedisTemplate:把k，v 都是作为String处理， 使用的是String的序列化 ， 可读性好;
	 */
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate<String, Object> objRedisTemplate;
	@Test
	public void testRedishash() {
		System.out.println(redisTemplate);
		System.out.println(stringRedisTemplate);
		
	}
	@Test
	public void testredisTemplateStr() {
		String str ="str_wangtao";
		redisTemplate.opsForValue().set("wangtao", "luse-wangtao");
		
		stringRedisTemplate.opsForValue().set("name", "wangtao");
		SysUser user = new SysUser();
		user.setPassword("123");
		user.setUsername("12345667@qq.com");
		//stringRedisTemplate.opsForHash().put("member-id", "3398660467@qq.com",user );
		
		objRedisTemplate.opsForHash().put("member-id", "3398660467@qq.com", user);
		SysUser object = (SysUser)objRedisTemplate.opsForHash().get("member-id", "3398660467@qq.com");
		System.out.println(object);
	}
}
