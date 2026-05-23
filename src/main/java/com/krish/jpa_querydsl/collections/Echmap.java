package com.krish.jpa_querydsl.collections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Echmap {
    public static void main(String[] args) {
        Map<String, String> map;
        map = new ConcurrentHashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");

        for(String key : map.keySet()) {
            map.put("key6", "value6");
            System.out.println(map.get(key));

        }
    }
}
