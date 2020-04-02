package com.example.hades.java._object._reusing._2_inheritance;

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