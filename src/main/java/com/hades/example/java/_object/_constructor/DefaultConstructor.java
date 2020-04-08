package com.hades.example.java._object._constructor;

public class DefaultConstructor {
    public static void main(String[] args) {
//        DefaultConstructor defaultConstructor = new DefaultConstructor();
        DefaultConstructor defaultConstructor = new DefaultConstructor("abc");
    }

    DefaultConstructor(String s) {
        System.out.println(s);
    }
}
