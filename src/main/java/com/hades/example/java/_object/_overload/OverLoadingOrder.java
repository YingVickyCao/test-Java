package com.hades.example.java._object._overload;

public class OverLoadingOrder {
    public static void main(String[] args) {
        OverLoadingOrder overLoadingOrder = new OverLoadingOrder();
        overLoadingOrder.f(1, "A");
        overLoadingOrder.f("B", 2);
    }

    private void f(final int i, final String s) {
        System.out.println(i + "," + s);
    }

    private void f(final String s, final int i) {
        System.out.println(i + "," + s);
    }
}