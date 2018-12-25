package com.example.hades.java.code._object._initial_value._static._3_explicit_static_init;

public class Cups {
    static int num = 1000;
    static Cup cup1;
    static Cup cup2;

    static {
        System.out.println("static init ------->");
        num = 20000;
        cup1 = new Cup(1);
        cup2 = new Cup(2);
        System.out.println("num:" + num);
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
