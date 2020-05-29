package com.hades.example.java._16_object._reusing._2_inheritance;

public class B extends A {
    public B() {
//        super();
        System.out.println("B constructor----->");
        System.out.println("B constructor<-----");
    }

    public static void main(String[] args){
        B b = new B();
    }
}