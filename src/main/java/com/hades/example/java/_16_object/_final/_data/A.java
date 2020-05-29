package com.hades.example.java._16_object._final._data;

public class A {
    protected int i;

    public A(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "{" +
                "i=" + i +
                '}';
    }
}
