package com.chenfei.cfgoweb.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/test_cluster")
    public String testCluster() throws InterruptedException {
        stringRedisTemplate.opsForValue().set("cftest", "666");
        log.info(stringRedisTemplate.opsForValue().get("cftest"));
        return stringRedisTemplate.opsForValue().get("cftest");
    }

}
