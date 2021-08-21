package com.chenfei.cfgoweb.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/test_cluster")
    public String testCluster() {
        String cache = stringRedisTemplate.opsForValue().get("cftest");
        if (StringUtils.hasText(cache)) {
            return cache;
        }
        String value = "666";
        boolean status = stringRedisTemplate.opsForValue().
                setIfAbsent("cftest", value, 1, TimeUnit.MINUTES);
        if (status) {
            log.info("setIfAbsent success");
            return value;
        } else {
            log.error("setIfAbsent fail");
            return null;
        }
    }
}
