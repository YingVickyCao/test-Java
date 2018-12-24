package com.example.hades.java.code._object._initial_value._by_constructor;

public class TestInitialValueByConstructor {
    /*
        W(1)
        W(3)
        W(2)
        W(4)
        H()--------->
        W(31)
        H()<---------
        void f()
     */
    public static void main(String[] args) {
        H h = new H();
        h.f();
    }
}