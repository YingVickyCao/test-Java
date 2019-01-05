package com.example.hades.java.code._object._polymorphism._constructor;

public class Meal {
    private static final String TAG = Meal.class.getSimpleName();

    private int i = 1;

    public Meal() {
        System.out.println(TAG + ",i=" + i + ",START");
        i = 2;
        System.out.println(TAG + ",i=" + i + ",END");
    }

    public void dispose() {
        System.out.println("DISPOSE," + TAG);
    }
}