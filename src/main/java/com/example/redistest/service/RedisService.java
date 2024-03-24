package com.example.redistest.service;


import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class RedisService {

    private final StringRedisTemplate redisTemplate;

    public RedisService(StringRedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    public void setValue(String key, String value){
        redisTemplate.opsForValue().set(key,value, Duration.ofSeconds(10));
    }
    public String getValue(String key){
       return (String) redisTemplate.opsForValue().get(key);
    }



}
