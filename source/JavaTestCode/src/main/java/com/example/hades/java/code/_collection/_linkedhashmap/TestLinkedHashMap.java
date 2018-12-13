package com.example.hades.java.code._collection._linkedhashmap;

import java.util.LinkedHashMap;

public class TestLinkedHashMap {
    public static void main(String[] args) {
        TestLinkedHashMap test = new TestLinkedHashMap();
//        test.accessOrder(true);
//        test.accessOrder(false);
//        test.testNull();
        test.testSameValue();
    }

    // test.accessOrder(true);
    /*
         {0=0, 1=1, 2=2}
         1
         {0=0, 2=2, 1=1}
         */
    // test.accessOrder(false);
    /*
        {0=0, 1=1, 2=2}
        1
        {0=0, 1=1, 2=2}
         */
    private void accessOrder(boolean accessOrder) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(12, 0.75f, accessOrder);
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        System.out.println(map);
        Integer value = map.get(1);
        System.out.println(value);
        System.out.println(map);
    }

    private void testNull() {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(12, 0.75f, true);
        map.put(0, 0);
        System.out.println(map);

        map.put(null, 1);
        System.out.println(map);

        // key=null, value!=null , when put same key  => override
        map.put(null, 2);
        System.out.println(map.get(null));
        System.out.println(map);

        // key!=null, value=null , when put same (key,value)  => override
        map.put(3, null);
        System.out.println(map);
        map.put(3, null);
        System.out.println(map);
    }

    /*
    {0=0, 3=31}
    {0=0, 3=32}
    32
     */
    private void testSameValue() {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>(12, 0.75f, true);
        map.put(0, 0);
        map.put(3, 31);
        System.out.println(map);
        map.put(3, 32);
        System.out.println(map);
        System.out.println(map.get(3));
    }
}
