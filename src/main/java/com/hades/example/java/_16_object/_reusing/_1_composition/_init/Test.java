package com.hades.example.java._16_object._reusing._1_composition._init;

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
