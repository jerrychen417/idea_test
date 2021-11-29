package com.atguigu.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("hadoop102", 6379);
//githup
//        jedis.sadd("xiyouji","tangsanzhang","xunwukong","zhubajie");
        jedis.expire("xiyouji",20);

        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }

        boolean b = true;
        while (b) {
            Long ttl = jedis.ttl("xiyouji");
            if (ttl == -2) {
                b=false;
                continue;
            }
            System.out.println(ttl);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        jedis.close();
    }
}
