package com.hades.example.java._object._abstract;

public class Child extends Parent {
    private static final String TAG = Child.class.getSimpleName();

    int n = 1;

    @Override
    String what() {
        return TAG;
    }

    @Override
    void print() {
        System.out.println(TAG + ",print(),n=" + n);
    }
}