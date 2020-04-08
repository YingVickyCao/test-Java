package com.hades.example.java._object._polymorphism;

public class Shape {
    private static final String TAG = Shape.class.getSimpleName();

    public void f1() {
        System.out.println(TAG + ".f1()");
    }

    public void f2() {
        System.out.println(TAG + ".f2()");
    }

    public void f3() {
        System.out.println(TAG + ".f3 called f1() START");
        f2();
        System.out.println(TAG + ".f3 called f1() END");
    }
}