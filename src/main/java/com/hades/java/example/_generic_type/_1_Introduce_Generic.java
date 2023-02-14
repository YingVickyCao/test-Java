package com.hades.java.example._generic_type;

import java.util.ArrayList;
import java.util.List;

public class _1_Introduce_Generic {
    public static void main(String[] args) {
        before_jdk_1_5();
        after_jdk_1_5();
    }

    /**
     * 为什么JDK 1.5 引入了泛型？
     * 集合存入元素后，在取元素时，不知道它的类型是什么。为了保证变量的类型安全，必须使用强制类型。这种转换使得代码混乱，而且容易发生类型转换异常ClassCastException
     */
    private static void before_jdk_1_5() {
        List list = new ArrayList<>();
        list.add(10);
        list.add("abc");
        list.add(20);

        Integer v0 = (Integer) list.get(0);
        String v1 = (String) list.get(1);

        // Error: Exception in thread "main" java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')
//        String v2 = (String) list.get(2);

        if (list.get(2) instanceof String) {
            String v2 = (String) list.get(2);
        }
    }

    private static void after_jdk_1_5() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(20);
        Integer v0 = integerList.get(0);
        Integer v1 = integerList.get(1);

        List<String> stringList = new ArrayList<>();
        stringList.add("abc");
        String v2 = stringList.get(0);
    }
}
