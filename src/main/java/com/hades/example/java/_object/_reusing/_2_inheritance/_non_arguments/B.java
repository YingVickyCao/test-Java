package com.hades.example.java._object._reusing._2_inheritance._non_arguments;

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