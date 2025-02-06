package com.it.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 设置 key-value
    public void setValue(String key, Object value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    // 获取 key-value
    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // 删除 key
    public void deleteKey(String key) {
        redisTemplate.delete(key);
    }
}
