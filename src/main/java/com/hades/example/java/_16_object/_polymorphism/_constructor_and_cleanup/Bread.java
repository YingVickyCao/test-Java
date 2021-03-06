package com.hades.example.java._16_object._polymorphism._constructor_and_cleanup;

public class Bread {
    private static final String TAG = Bread.class.getSimpleName();

    public Bread() {
        System.out.println(TAG);
    }

    public void dispose() {
        System.out.println("DISPOSE," + TAG);
    }
}