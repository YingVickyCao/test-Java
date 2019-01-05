package com.example.hades.java.code._object._polymorphism._override_private;

public class Shape {
    private static final String TAG = Shape.class.getSimpleName();
    private void f5() {
        System.out.println(TAG + ".f5()");
    }


    public static void main(String[] args) {
        Shape shape = new Circle();
        shape.f5();
    }
}