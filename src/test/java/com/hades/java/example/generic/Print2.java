package com.hades.java.example.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Print2 {

    @Test
    public void test_1() {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);

        List<Long> longList = new ArrayList<>();
        longList.add(3L);
        longList.add(4L);

        printUpper(intList);
        printUpper(longList);

        printUpper2(intList);
        printUpper2(longList);
    }

    /**
     * <T extends Number>：类型参数上界 (Type Parameter Upper Bound):表示T 这个具体类型被限制在 Number的层级之下。
     */
    <T extends Number> void printUpper(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }

    /**
     * <? extends Number> : 通配符上界(Wildcard Upper Bound)：表示 ?这个未知类型被限制在 Number的层级之下。
     */
    void printUpper2(List<? extends Number> list) {
        for (Number element : list) {
            System.out.println(element);
        }
    }
}
