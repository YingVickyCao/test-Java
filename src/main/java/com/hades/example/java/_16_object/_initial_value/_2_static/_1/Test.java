package com.hades.example.java._16_object._initial_value._2_static._1;

public class Test {
    public static void main(String[] args) {
        new Counter(2);
    }

    static Counter counter = new Counter(1);
}