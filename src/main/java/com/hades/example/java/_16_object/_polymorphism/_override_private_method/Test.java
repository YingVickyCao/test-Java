package com.hades.example.java._16_object._polymorphism._override_private_method;

public class Test {
    public static void main(String[] args) {
        Shape shape = new Circle();
        ((Circle) shape).f5();
        System.out.println();
    }
}