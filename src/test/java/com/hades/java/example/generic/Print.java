package com.hades.java.example.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Print {

    @Test
    public void test_1() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);

        printGeneric(intList);
        printGeneric(stringList);

        printWildcard(intList);
        printWildcard(stringList);
    }

    /**
     *  <T>：类型参数 (Type Parameter):表示一个未指定的具体类型。
     */
    <T> void printGeneric(List<T> list) { // 泛型方法
        // 泛型方法可以处理任何具体类型的 List
        // <T>: 类型参数
        for (T element : list) {
            System.out.println(element);
        }
    }

    /**
     * <?>：无界通配符 (Unbounded Wildcard)：表示一个未知的任何类型
     * 适合只读操作，不关系类型。
     */
    void printWildcard(List<?> list) { // 无界通配符
        // ?：这是一个无界通配符。它表示“任何类型”。
        // 这种写法非常灵活，可以接收任何类型的 List,但对该列表元素的具体类型“一无所知”（只能当作 Object 处理）。
        for (Object element : list) {
            System.out.println(element);
        }
    }
}
