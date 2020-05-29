package com.hades.example.java._16_object._initial_value._full_process;

public class Child extends Parent {
    private int k = printInit("Wheat.k init");

    public Child() {
//        super();
        System.out.println("Wheat(),k=" + k + ",j=" + j);
    }

    private static int x2 = printInit("Wheat.x2 init");
}