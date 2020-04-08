package com.hades.example.java._object._polymorphism._constructor_and_cleanup;

public class Meal {
    private static final String TAG = Meal.class.getSimpleName();

    private int i = 1;

    public Meal() {
        System.out.println(TAG + " constructor" + ",i=" + i + ",START");
        i = 2;
        System.out.println(TAG + " constructor" + ",i=" + i + ",END");
    }

    public void dispose() {
        System.out.println("DISPOSE," + TAG);
    }
}