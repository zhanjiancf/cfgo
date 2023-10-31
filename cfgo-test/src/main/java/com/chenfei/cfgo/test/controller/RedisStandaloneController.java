package com.chenfei.cfgo.test.controller;

import io.lettuce.core.KeyScanCursor;
import io.lettuce.core.ScanArgs;
import io.lettuce.core.ScanCursor;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions <TODO description class purpose>
 * @create 2023/6/27 10:31
 */
@Slf4j
@RestController
@RequestMapping("/redisStandalone")
public class RedisStandaloneController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private static final String KEY_PREFIX = "cfgo:test:id:";

    @RequestMapping("/test")
    public String test() {
        String cache = stringRedisTemplate.opsForValue().get("cftest");
        if (StringUtils.hasText(cache)) {
            return cache;
        }
        String value = "999";
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

    @RequestMapping("generateDataToRedis")
    public void generateDataToRedis() {
        for (int i = 0; i < 10000; i++) {
            stringRedisTemplate.opsForValue()
                    .set(KEY_PREFIX + i, String.valueOf(i), 60, TimeUnit.MINUTES);
        }
    }

    @RequestMapping("/syncRedisDataToDb")
    public void syncRedisDataToDb() {
        RedisAsyncCommands redisAsyncCommands = (RedisAsyncCommands) stringRedisTemplate.getRequiredConnectionFactory().getConnection().getNativeConnection();
        RedisCommands redisCommands = redisAsyncCommands.getStatefulConnection().sync();
        ScanArgs scanArgs = ScanArgs.Builder.matches(KEY_PREFIX + "*").limit(500);
        Set<String> keySet = Collections.synchronizedSet(new HashSet<>(1000));
        ScanCursor keyScanCursor = ScanCursor.INITIAL;
        do {
            keyScanCursor = redisCommands.scan(keyScanCursor, scanArgs);
            List<String> keyScanCursorKeys = ((KeyScanCursor)keyScanCursor).getKeys();
            keySet.addAll(keyScanCursorKeys);
        } while (!keyScanCursor.isFinished());
        log.info("keySet size:{}", keySet.size());
    }
}
