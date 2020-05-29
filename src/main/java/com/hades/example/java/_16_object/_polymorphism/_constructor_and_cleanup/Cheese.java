package com.hades.example.java._16_object._polymorphism._constructor_and_cleanup;

public class Cheese {
    private static final String TAG = Cheese.class.getSimpleName();

    public Cheese() {
        System.out.println(TAG);
    }

    public void dispose() {
        System.out.println("DISPOSE," + TAG);
    }
}