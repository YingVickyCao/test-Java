package com.example.hades.java;

public class Test {
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        System.out.println("ABC");
        System.out.println(tableSizeFor(1000));
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        System.out.println(n);
        System.out.println(n >>> 1);
        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;
        System.out.println(n);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}