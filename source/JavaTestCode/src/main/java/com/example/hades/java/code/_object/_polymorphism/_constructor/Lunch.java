package com.example.hades.java.code._object._polymorphism._constructor;

public class Lunch extends Meal {
    private static final String TAG = Lunch.class.getSimpleName();
    Bread bread = new Bread();
    Cheese cheese = new Cheese();

    public Lunch() {
        System.out.println(TAG);
    }

    public void dispose() {
        super.dispose();
        cheese.dispose();
        bread.dispose();

        System.out.println("DISPOSE," + TAG);
    }

    public static void main(String[] args) {
        Lunch lunch = new Lunch();
        lunch.dispose();
    }
}