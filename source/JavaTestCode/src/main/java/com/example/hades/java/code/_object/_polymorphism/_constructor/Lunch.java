package com.example.hades.java.code._object._polymorphism._constructor;

public class Lunch extends Meal {
    private static final String TAG = Lunch.class.getSimpleName();
    Bread bread = new Bread();
    Cheese cheese = new Cheese();

    public Lunch() {
        System.out.println(TAG);
    }

    public static void main(String[] args) {
        Lunch lunch = new Lunch();
    }
}
