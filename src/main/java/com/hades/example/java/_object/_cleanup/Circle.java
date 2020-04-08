package com.hades.example.java._object._cleanup;

public class Circle extends Shape {
    private static final String TAG = Circle.class.getSimpleName();

    Circle(int size) {
        super(size);
        System.out.println(TAG + " Constructor ---------->");
        System.out.println(TAG + " Constructor <----------");
        System.out.println();
    }

    void clean() {
        System.out.println(TAG + " clean() ---------->");
        super.clean();
        System.out.println(TAG + " clean() <----------");
        System.out.println();
    }
}