package moon.sun;

import redis.clients.jedis.Jedis;

public class redis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("121.43.177.234",6666);
         jedis.auth("password");
        System.out.println("连接成功");
        System.out.println("服务正在运行: "+jedis.ping());
        System.out.println("redis 存储的字符串为: "+ jedis.get("DevOps"));
    }
}