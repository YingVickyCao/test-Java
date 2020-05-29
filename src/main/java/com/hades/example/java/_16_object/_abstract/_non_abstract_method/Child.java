package com.hades.example.java._16_object._abstract._non_abstract_method;

public class Child extends Parent {
    private static final String TAG = Child.class.getSimpleName();

    String what() {
        return TAG;
    }
}