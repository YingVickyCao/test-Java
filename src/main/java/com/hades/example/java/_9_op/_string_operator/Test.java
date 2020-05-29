package com.hades.example.java._9_op._string_operator;

public class Test {
    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        String s = "abc";

        System.out.println(x + y);
        System.out.println(s + x + y);
        System.out.println(s + (x + y));
    }
}
