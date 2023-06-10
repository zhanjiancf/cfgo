package com.chenfei.cfgo.test.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions <TODO description class purpose>
 * @create 2023/4/14 10:12
 */
public class CacheCapacityTest {
    public static void main(String[] args) {
        Cache<String,String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .build();
        cache.put("key1","value1");
        cache.put("key2","value2");
        cache.put("key3","value3");
        System.out.println("第一个key1值：" + cache.getIfPresent("key1"));
        System.out.println("第二个key2值：" + cache.getIfPresent("key2"));
        System.out.println("第三个key3值：" + cache.getIfPresent("key3"));
    }
}
