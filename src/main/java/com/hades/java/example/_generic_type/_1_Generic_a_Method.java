package com.hades.java.example._generic_type;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型方法
 */
public class _1_Generic_a_Method {
    public static void main(String[] args) {
        {
            print(1);
            print("6hh");
        }

        {
            print2(1);
            print2("6hh");
        }

        {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);

            int result = fistValueInList("6hh", list);
            System.out.println(result);
        }

    }

    private static void print(int t) {
        System.out.println(t);
    }

    private static void print(String t) {
        System.out.println(t);
    }

    /**
     * 泛型方法
     * 传入的参数可以任意类型，int，sting等。
     */
    private static <T> void print2(T t) {
        System.out.println(t);
    }


    /**
     * 泛型方法
     * 它的返回值也是一个任意类型。
     *
     * @param t
     * @param vList
     * @param <T>   这个方法有任意类型，用T表示
     * @param <V>   这个方法有任意类型，用V表示
     * @return 返回一个V
     */
    private static <T, V> V fistValueInList(T t, List<V> vList) {
        System.out.println(t);
        return vList.get(0);
    }
}
