package com.hades.example.java._16_object._polymorphism._static_method;

public class Test {
    public static void main(String[] args) {
        Base base = new Derived();
        System.out.println(base.staticGet());
        System.out.println(base.dynamicGet());
    }
}