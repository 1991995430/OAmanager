package com.offcn.jties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JtiesTest {

	public static void main(String[] args) {
		
		/*
		 * Jedis jedis = new Jedis("192.168.220.128",6379);
		 * 
		 * jedis.set("ss", "shangsong");
		 * 
		 * List list = new ArrayList();
		 * 
		 * jedis.lpush("list", "1","2","3");
		 * 
		 * List<String> list2 = jedis.lrange("list", 0,-1);
		 * 
		 * System.out.println(list2);
		 * 
		 * jedis.close();
		 */
		
		
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(16);
		config.setMaxIdle(6);
		config.setMinIdle(3);
		JedisPool jedisPool = new JedisPool(config, "192.168.220.128", 6379);
		
		Jedis jedis = jedisPool.getResource();
		String name = jedis.get("ss");
		System.out.println("name::"+name);
		
		jedis.close();

	}

}
