package com.hades.example.java._16_object._access_control._import_4_debug.debugoff;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.debug();
    }

    private void debug() {
        System.out.println(" Off Debug");
    }
}
