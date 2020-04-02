package com.example.hades.java._object._access_control._private._singleton;


public class Test {
    public static void main(String[] args){
        A2 a2 = A2.getInstance(10);
        System.out.println(a2.getN());
//        System.out.println(a2.n);
    }
}