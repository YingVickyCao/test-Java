package com.hades.example.java._7_collection._hashmap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestLoopHashMap {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    private final int MAX_SIZE_10000 = 10000; // 10,000
    private final int MAX_SIZE_100000 = 100000; // 100,000
    private final int MAX_SIZE_1000000 = 1000000;// 1,000,000
    private final int MAX_SIZE_2000000 = 2000000;   // 2,000,000

    public static void main(String[] args) throws IOException {
        TestLoopHashMap test = new TestLoopHashMap();
        test.intMap();

        long ts1 = System.currentTimeMillis();
        test.forEach();
        long ts2 = System.currentTimeMillis();
        System.out.println("forEach()=" + (ts2 - ts1) + " ms");

        ts1 = System.currentTimeMillis();
        test.forEach_key();
        ts2 = System.currentTimeMillis();
        System.out.println("forEach_key()=" + (ts2 - ts1) + " ms");

        ts1 = System.currentTimeMillis();
        test.forEach_value();
        ts2 = System.currentTimeMillis();
        System.out.println("forEach_value()=" + (ts2 - ts1) + " ms");

        ts1 = System.currentTimeMillis();
        test.iterator();
        ts2 = System.currentTimeMillis();
        System.out.println("iterator()=" + (ts2 - ts1) + " ms");

        ts1 = System.currentTimeMillis();
        test.java8Lambda();
        ts2 = System.currentTimeMillis();
        System.out.println("java8Lambda()=" + (ts2 - ts1) + " ms");
    }

    private void intMap() {
//        map.put(1, 10);
//        map.put(2, 20);

        for (int i = 0; i < MAX_SIZE_1000000; i++) {
            map.put(i + 1, i + 1);
        }
    }

    /**
     * Way 1 : Foreach - map.entrySet()
     * key and value
     * Recommend, especially when map capacity is large
     */
    private void forEach() {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    /**
     * Way 2 : Foreach only for key - map.keySet()
     */
    private void forEach_key() {
        // Key
        for (Integer key : map.keySet()) {
//            System.out.println("Key = " + key);
        }
    }

    /**
     * Way 3 : Foreach only for value - map.values()
     */
    private void forEach_value() {
        // Value
        for (Integer value : map.values()) {
//            System.out.println("Value = " + value);
        }
    }

    /**
     * Way 4 : Iterator
     * key and value
     */
    private void iterator() {
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    /**
     * Way 5 : Java8 Lambda
     * key and value
     */
    private void java8Lambda() {
        map.forEach((k, v) -> {
//            System.out.println("key: " + k + " value:" + v);
        });
    }
}
