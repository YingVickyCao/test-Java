package com.hades.example.java._object._access_control._private;

public class Test {
    public static void main(String[] args) {
        A a = A.createA(5);
        System.out.println(a.getN());
    }
}