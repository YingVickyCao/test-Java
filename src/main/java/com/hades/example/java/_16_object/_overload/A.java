package com.hades.example.java._16_object._overload;

public class A {
    public A() {
    }

    void f(float f) {
        System.out.println("f(float)");
    }

    void f(char f) {
        System.out.println("f(char) in A");
    }
}
