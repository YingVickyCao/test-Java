package com.example.hades.java.code._object._reusing._inheritance;

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