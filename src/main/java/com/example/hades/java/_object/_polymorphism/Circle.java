package com.example.hades.java._object._polymorphism;

public class Circle extends Shape {
    private static final String TAG = Circle.class.getSimpleName();

    public void f1() {
        System.out.println(TAG + ".f1()");
    }

    public void f2() {
        System.out.println(TAG + ".f2()");
    }
}