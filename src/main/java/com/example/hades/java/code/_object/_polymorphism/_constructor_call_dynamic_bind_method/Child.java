package com.example.hades.java.code._object._polymorphism._constructor_call_dynamic_bind_method;

public class Child extends Parent {
    private static final String TAG = "Wheat";
    public int i = 1;

    public Child(int i) {
        System.out.println(TAG + " constructor,i=" + i + ",START");
        this.i = i;
        System.out.println(TAG + " constructor,i=" + i + "," +
                "END");
    }

    public void draw() {
        System.out.println(TAG + ".draw(),i=" + i);
    }
}