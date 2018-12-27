package com.example.hades.java.code._object._reusing._init;

public class A {
    private String s = "A"; // 1

    public A(String s) {
        this.s = s; // 2
    }

    @Override
    public String toString() {
        return "A{" +
                "s='" + s + '\'' +
                '}';
    }
}
