package com.example.hades.java.code._object._reusing;

public class Test {
    private A a;

    public static void main(String[] args) {
        Test test = new Test();
        test.test();
    }

    private void test() {
        a = new A("A2"); // 3
        System.out.println(a.toString());
    }
}
