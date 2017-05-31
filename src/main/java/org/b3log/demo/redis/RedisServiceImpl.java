package org.b3log.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Created by yu.zhang on 2017/5/31.
 */
public class RedisServiceImpl {
    @Autowired
    private RedisTemplate redisTemplate;

    public String findCityById() {
        // 从缓存中获取城市信息
        String key = "city_1";
        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            String city = operations.get(key);
            System.out.println(city);
            return city;
        }

        // 从 DB 中获取城市信息
//        City city = cityDao.findById(id);
        String city="Beijing";
        // 插入缓存
        operations.set(key, city);
        System.out.println("insert a new key:>"+key);
        return null;
    }
}
