package com.example.hades.java._object._polymorphism._constructor_and_cleanup;

public class Lunch extends Meal {
    private static final String TAG = Lunch.class.getSimpleName();
    Bread bread = new Bread();
    Cheese cheese = new Cheese();

    public Lunch() {
        System.out.println(TAG+" constructor,START");
        System.out.println(TAG+" constructor,END");
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