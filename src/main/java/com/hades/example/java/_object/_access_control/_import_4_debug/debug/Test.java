package com.hades.example.java._object._access_control._import_4_debug.debug;

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
