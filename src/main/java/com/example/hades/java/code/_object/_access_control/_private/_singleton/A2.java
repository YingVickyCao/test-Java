package com.example.hades.java.code._object._access_control._private._singleton;

public class A2 {
    private int n;
    private static A2 mInstance;

    private A2(int n) {
        this.n = n;
    }

    static A2 getInstance(int n) {
        mInstance = new A2(n);
        return mInstance;
    }

    public int getN() {
        return n;
    }
}