package com.hades.example.java._16_object._polymorphism;

public class Test {
    public static void main(String[] args) {
        Shape shape = new Circle();
        Shape shape2 = new Square();

        shape.f1();
        shape.f2();
        shape.f3();
        System.out.println();

        shape2.f1();
        shape2.f2();
        shape2.f3();
    }
}