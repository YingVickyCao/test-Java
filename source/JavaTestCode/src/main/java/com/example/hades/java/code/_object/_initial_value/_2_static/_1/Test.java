package com.example.hades.java.code._object._initial_value._2_static._1;

public class Test {
    public static void main(String[] args) {
        new Counter(2);
    }

    static Counter counter = new Counter(1);
}