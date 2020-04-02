package com.example.hades.java._object._initial_value._full_process;

public class Parent {
    private int i = 9;
    protected int j;

    public Parent() {
        System.out.println("Grain()----> i=" + i + ",j=" + j);
        j = 39;
        System.out.println("Grain()<---- i=" + i + ",j=" + j);
    }

    private static int x1 = printInit("Grain.x1 init");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}
