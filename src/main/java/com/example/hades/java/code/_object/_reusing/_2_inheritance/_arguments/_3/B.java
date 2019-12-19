package com.example.hades.java.code._object._reusing._2_inheritance._arguments._3;

public class B extends A {
    public B() {
        System.out.println("B() constructor----->");
        System.out.println("B() constructor<-----");
    }

    public B(int num) {
        System.out.println("B(int) constructor----->");
        System.out.println("B(int) constructor<-----");
    }

    public static void main(String[] args) {
        B b = new B(5);

        System.out.println();

        B b2 = new B();
    }
}