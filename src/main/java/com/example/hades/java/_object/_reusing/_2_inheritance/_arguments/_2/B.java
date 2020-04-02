package com.example.hades.java._object._reusing._2_inheritance._arguments._2;

public class B extends A {
    public B(int num) {
        super(num); // If not call super, ERROR:There is no default constructor available
//        System.out.println("B(int) constructor----->");
        System.out.println("B(int) constructor<-----");
    }

    // ERROR:There is no default constructor available
//    public B(){
//
//    }
    public static void main(String[] args) {
        B b = new B(5);
    }
}