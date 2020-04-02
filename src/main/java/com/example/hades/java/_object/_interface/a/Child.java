package com.example.hades.java._object._interface.a;

public class Child implements IInfo {
    private static final String TAG = Child.class.getSimpleName();

    int n = 1;

    @Override
    public String what() {
        return TAG;
    }

    @Override
    public void print() {
        System.out.println(TAG + ",print(),n=" + n);
    }
}