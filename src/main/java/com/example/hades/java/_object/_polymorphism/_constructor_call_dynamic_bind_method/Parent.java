package com.example.hades.java._object._polymorphism._constructor_call_dynamic_bind_method;

public class Parent {
    private static final String TAG = Parent.class.getSimpleName();

    public Parent() {
        System.out.println(TAG + " constructor,START");
        draw();
        System.out.println(TAG + " constructor,END");
        System.out.println();
    }

    public void draw() {
        System.out.println(TAG + ".draw()");
    }
}