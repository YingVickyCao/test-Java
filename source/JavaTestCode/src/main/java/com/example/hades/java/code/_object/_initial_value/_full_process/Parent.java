package com.example.hades.java.code._object._initial_value._full_process;

public class Parent {
    private int i = 9;
    protected int j;

    public Parent() {
        System.out.println("Parent()----> i=" + i + ",j=" + j);
        j = 39;
        System.out.println("Parent()<---- i=" + i + ",j=" + j);
    }

    private static int x1 = printInit("Parent.x1 init");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}
