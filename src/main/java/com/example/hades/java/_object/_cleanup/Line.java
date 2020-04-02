package com.example.hades.java._object._cleanup;

public class Line extends Shape {
    private static final String TAG = Line.class.getSimpleName();

    Line(int size) {
        super(size);
        System.out.println(TAG + " Constructor ---------->");
        System.out.println(TAG + " Constructor <----------");
    }

    void clean() {
        System.out.println(TAG + " clean() ---------->");
        super.clean();
        System.out.println(TAG + " clean() <----------");
        System.out.println();
    }
}