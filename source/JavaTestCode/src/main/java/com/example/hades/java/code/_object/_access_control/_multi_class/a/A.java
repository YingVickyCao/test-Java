package com.example.hades.java.code._object._access_control._multi_class.a;

public class A {
    private int a;

    A(int a) {
        this.a = a;
    }

    int getA() {
        return a;
    }

    class M {
        int m;

        public M() {
        }
    }
}