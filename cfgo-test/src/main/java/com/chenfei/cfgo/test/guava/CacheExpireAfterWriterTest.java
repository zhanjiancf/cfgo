package com.chenfei.cfgo.test.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions <TODO description class purpose>
 * @create 2023/4/14 11:10
 */
public class CacheExpireAfterWriterTest {
    public static void main(String[] args) throws InterruptedException {
        Cache<String,String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .build();
        cache.put("key1","value1");
        int time = 1;
        while(true) {
            System.out.println("第" + time++ + "次取到key1的值为：" + cache.getIfPresent("key1"));
            Thread.sleep(1000);
        }
    }
}
