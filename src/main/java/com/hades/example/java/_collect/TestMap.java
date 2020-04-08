package com.hades.example.java._collect;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    private Map<String, String> map = new HashMap<>();

    public void test() {
        System.out.println("TestMap," + "test," + (null == map ? "map=null" : "map.hashCode()=" + map.hashCode() + ",map.size()=" + map.size()));
        map.put("A,", "A");
        System.out.println("TestMap," + "test," + (null == map ? "map=null" : "map.hashCode()=" + map.hashCode() + ",map.size()=" + map.size()));

        map.put("A,", "A");
        System.out.println("TestMap," + "test," + (null == map ? "map=null" : "map.hashCode()=" + map.hashCode() + ",map.size()=" + map.size()));
    }
}
