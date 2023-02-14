package com.hades.java.example._generic_type;

/**
 * 范型方法
 */
public class GenericMethod {
    public static void main(String[] args) {
        {
            print(1);
            print("abc");
        }

        {
            print2(1);
            print2("abc");
        }

    }

    private static void print(int t) {
        System.out.println(t);
    }

    private static void print(String t) {
        System.out.println(t);
    }

    /**
     * 范型方法
     * 传入的参数可以任意类型，int，sting等。
     */
    private static <T> void print2(T t) {
        System.out.println(t);
    }
}
