package com.hades.example.java._16_object._final._method;

public class Test {

    public static void main(String[] args) {
        A a = new B();
        A b = new B2();

        ((B2) b).f();
        ((B2) b).g();
    }
}