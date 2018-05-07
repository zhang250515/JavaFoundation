package redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by ZhangQ on 2018/5/6.
 */
public class HelloRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("connect");
        System.out.println("status: " + jedis.ping());
        System.out.println("get myKey: " + jedis.get("myKey"));
        Set<String> keys = jedis.keys("*");
        keys.iterator().forEachRemaining(System.out::println);
    }
}
