package com.example.hades.java.code._object._initial_value._static._3_explicit_init;

public class Cups {
    static int num = 98;
    static Cup cup1;
    static Cup cup2;

    static {
        System.out.println("static init ------->");
        cup1 = new Cup(1);
        cup2 = new Cup(2);
        System.out.println("num:" + num);
        num = 99;
        System.out.println("num:" + num);
        System.out.println("static init <-------");
    }

    public Cups() {
        System.out.println("Cups()");
    }

//    public static void main(String[] args) {
//        Cups.cup1.f(99);
//    }
}
