package com.hades.example.java._object._overload;

public class PrimitiveOverloading2 {
    public static void main(String[] args) {
        PrimitiveOverloading2 test = new PrimitiveOverloading2();

        test.testLong();
        System.out.println();
    }

    private void testLong() {
        System.out.print("long:");
        long x = 1;
        f4((int) x);
    }

    private void f4(int x) {
        System.out.print("f4(int)   ");
    }
}