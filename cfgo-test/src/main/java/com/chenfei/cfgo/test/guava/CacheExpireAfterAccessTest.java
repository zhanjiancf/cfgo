package com.chenfei.cfgo.test.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions <TODO description class purpose>
 * @create 2023/4/14 11:18
 */
public class CacheExpireAfterAccessTest {
    public static void main(String[] args) throws InterruptedException {
        Cache<String,String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .expireAfterAccess(3, TimeUnit.SECONDS)
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .build();
        Thread.sleep(5000);
        cache.put("key1","value1");
        Thread.sleep(1900);
        int time = 1;
        while(true) {
            Thread.sleep(time * 1000);
            System.out.println("睡眠" + time + "秒后取到key1的值为：" + cache.getIfPresent("key1"));
//            time++;
        }
    }
}