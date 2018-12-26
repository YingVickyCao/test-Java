package com.example.hades.java.code._object._access_control.debug;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.debug();
    }

    private void debug() {
        System.out.println("On Debug");
        System.out.println("A B C");
    }
}
