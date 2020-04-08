package com.hades.example.java._object._access_control._private;

public class A {
    private int n;

    private A(int n) {
        this.n = n;
    }

    static A createA(int n) {
        return new A(n);
    }

    public int getN() {
        return n;
    }
}
