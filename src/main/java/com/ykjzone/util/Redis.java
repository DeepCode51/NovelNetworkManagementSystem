package com.ykjzone.util;

import redis.clients.jedis.Jedis;

public class Redis {
    public static Jedis JEDIS = new Jedis("localhost");
}
