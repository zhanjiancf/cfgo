package com.chenfei.cfgo.test.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 464498258@qq.com
 * @version 1.0.0
 * @descriptions <TODO description class purpose>
 * @create 2023/9/25 10:21
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("1","aa");
        map.put("2","bb");
        map.put("3","cc");
        map.put("4","dd");
        map.put("1","aa2");
        map.put("3","cc2");
        System.out.println(map);
    }
}
