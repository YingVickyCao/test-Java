package com.hades.example.java._16_object._polymorphism._override_private_method;

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