package com.hades.example.java._object._cleanup;

public class Shape {
    private static final String TAG = Shape.class.getSimpleName();

    Shape(int size) {
        System.out.println(TAG + " Constructor ---------->");
        System.out.println(TAG + " Constructor <----------");
    }

    void clean() {
        System.out.println(TAG + " clean() ---------->");
        System.out.println(TAG + " clean() <----------");
    }
}