package com.hades.example.java._object._overload;

public class B extends A {
    void f(String s) {
        System.out.println("f(String)");
    }


    @Override
    void f(char f) {
//        super.f(f);
        System.out.println("f(char) in B");
    }


//    @Override
//    void f(long f) {
//        System.out.println("f(char) in B");
//    }

    public static void main(String[] args) {
        B b = new B();
        b.f('A');
        b.f("Hello");
        b.f(5.0f);
    }
}
