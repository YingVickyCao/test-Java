package com.example.hades.java._object._polymorphism._override_private_method;

public class Circle extends Shape {
    private static final String TAG = Circle.class.getSimpleName();

    public void f5() {
        System.out.println(TAG + ".f5()");
    }
}