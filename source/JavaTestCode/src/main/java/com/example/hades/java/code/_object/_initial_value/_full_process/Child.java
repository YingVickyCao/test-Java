package com.example.hades.java.code._object._initial_value._full_process;

public class Child extends Parent {
    private int k = printInit("Child.k init");

    public Child() {
//        super();
        System.out.println("Child(),k=" + k + ",j=" + j);
    }

    private static int x2 = printInit("Child.x2 init");
}