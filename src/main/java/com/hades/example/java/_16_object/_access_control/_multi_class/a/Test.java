package com.hades.example.java._16_object._access_control._multi_class.a;

public class Test {
    public static void main(String[] args){
        A a = new A(1);
        System.out.println(a.getA() + ","+a.getH().s);

        /**
         * ERROR:A is is not an enclosing class
         * Make H static
         */
//        A.H h1 = new A.H("H1");

        A.H h2 = a.new H("H2");
        System.out.println(h2.s);
    }
}