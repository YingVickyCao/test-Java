package com.hades.example.java._array._varargs;

public class OverloadingVarargs {
    public static void main(String[] args) {
        f(new Integer(1), new Integer(2));
        f(3, 4);
        f(5, new Integer(6));

        f('a', 'b');

        f(0L);
    }

    public static void f(Integer... args) {
        System.out.print("First:  ");
        for (Integer item : args) {
            System.out.print(item + "  ");
        }
        System.out.println();
    }

    public static void f(Character... args) {
        System.out.print("Second: ");
        for (Character item : args) {
            System.out.print(item + "  ");
        }
        System.out.println();
    }

    public static void f(Long... args) {
        System.out.print("Third:  ");
        for (Long item : args) {
            System.out.print(item + "  ");
        }
        System.out.println();
    }
}
