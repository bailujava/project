package test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
    private static JedisPool pool = null;
    static{
        /**
         * 连接池参数的配置
         */
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);
        jedisPoolConfig.setMaxIdle(10);
        pool = new JedisPool(jedisPoolConfig,"192.168.163.133",6379);
    }

    public static Jedis getJedis(){
        return pool.getResource();
    }
    // 释放资源
}
