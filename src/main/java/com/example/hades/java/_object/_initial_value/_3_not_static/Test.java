package com.example.hades.java._object._initial_value._3_not_static;

public class Test {
    public static void main(String[] args) {
        System.out.println("----------First new---------->");
        new Cups();
        System.out.println("<----------First new----------");

        System.out.println("----------Second new---------->");
        new Cups(1000);
        System.out.println("<----------Second new----------");
    }
}