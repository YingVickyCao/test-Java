package com.hades.example.java._7_collection._hashmap;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    Map<Integer, Integer> map;

    public static void main(String[] args) {
        System.out.println(tableSizeFor(12));
        new TestHashMap().capacity();
    }

    // 12,0.75,16
    // 24,0.75,32
    private void capacity() {
        if (null == map) {
//            map = new HashMap<>();
            map = new HashMap<>(12);
        }
        for (int i = 1; i <= 17; i++) {
            map.put(i, i);
        }
    }
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        final int MAXIMUM_CAPACITY = 2147483647;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
