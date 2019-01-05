package com.example.hades.java.code._object._polymorphism._constructor;

public class Cheese {
    private static final String TAG = Cheese.class.getSimpleName();

    public Cheese() {
        System.out.println(TAG);
    }

    public void dispose() {
        System.out.println("DISPOSE," + TAG);
    }
}