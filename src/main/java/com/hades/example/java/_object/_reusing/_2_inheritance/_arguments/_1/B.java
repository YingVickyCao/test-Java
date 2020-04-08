package com.hades.example.java._object._reusing._2_inheritance._arguments._1;

public class B extends A {
    public B(int num) {
        super(num); // If not call super, ERROR:There is no default constructor available
        System.out.println("B(int) constructor----->");
        System.out.println("B(int) constructor<-----");
    }

    public static void main(String[] args) {
        B b = new B(5);
    }
}