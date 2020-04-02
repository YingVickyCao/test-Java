package com.example.hades.java._object._interface.a;

public abstract class Parent {
    private static final String TAG = Parent.class.getSimpleName();

    public Parent() {
        System.out.println(TAG + " Constructor,START");
        print();
        System.out.println(TAG + " Constructor,END");
        System.out.println();
    }

    abstract String what();

    abstract void print();
}