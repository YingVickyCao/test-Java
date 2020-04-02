package com.example.hades.java._array._varargs;

public class NewVarArgs {

    public static void f(Long... args) {
        System.out.print(args.getClass() + " - ");
        for (Long item : args) {
            System.out.print(item + "  ");
        }
        System.out.println();
    }

    public static void f(int... args) {
        System.out.print(args.getClass() + " - ");
        for (int item : args) {
            System.out.print(item + "  ");
        }
        System.out.println();
    }

    public static void k(int... args) {
        System.out.print(args.getClass() + " - ");
        for (int item : args) {
            System.out.print(item + "  ");
        }
        System.out.println();
    }

    public static void g(Character... args) {
        System.out.print(args.getClass() + " - ");
    }

    public static void main(String[] args) {
        f(new Long(1), new Long(2));
        f(3,4);
        k(5,6);
        k();
    }
}