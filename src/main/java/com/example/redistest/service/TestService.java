package com.example.redistest.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class TestService {

    private final RedisService redisService;

    private int key = 0;
    private int value = 0;
    private String ais = "AIS";
    private String enav = "ENAV";
    private String keyKind = "";
    private Boolean togle = true;

    @Autowired
    public TestService(RedisService redisService) {
        this.redisService = redisService;
    }


    @Scheduled(initialDelay = 1, fixedRate = 100)
    public void set() throws InterruptedException {
        StringBuilder keyBuilder = new StringBuilder();
        keyKind = togle ? ais : enav;
        keyBuilder.append(keyKind).append(":").append(key);
        System.out.println("set : " + keyBuilder.toString());
        redisService.setValue(keyBuilder.toString(), String.valueOf(value));
        key++;
        value++;
        togle = !togle;
    }

    //    @PostConstruct
    public void get() throws InterruptedException {
        int key = 0;
        int value = 0;
        while (true) {
            System.out.println("key : " + key + " value : " + redisService.getValue(String.valueOf(key)));
            key++;
            value++;
            Thread.sleep(5000);
        }
    }
}
