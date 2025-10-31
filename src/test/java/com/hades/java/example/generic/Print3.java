package com.hades.java.example.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Print3 {

    @Test
    public void test_1() {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);

        List<Number> numberList = new ArrayList<>();
        numberList.add(3L);
        numberList.add(4L);

        print2(intList);
        print2(numberList);
    }

    /**
     * <? super Integer> : 通配符下界 (Lower Bounded Wildcard): 表示？这个未知类型被限制在Integer的层级之上。
     */
    void print2(List<? super Integer> list) { // 接收 Integer 或其父类的列表
        // 正确的读取方式：只能读取 Object 类型,不能读取Integer
        for (Object element : list) {
            System.out.println(element);
        }
    }

    /**
     * <T super Number> 是一种不存在的 Java 泛型语法。 Java 不允许直接用 super 来声明类型参数的下界。
     */
}
