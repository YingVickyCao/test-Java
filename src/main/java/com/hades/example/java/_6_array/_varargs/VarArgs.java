package com.hades.example.java._6_array._varargs;

public class VarArgs {

    public static void f(Object[] args) {
        for (Object item : args) {
            System.out.print(item + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        f(new Object[]{new Integer(1), new Integer(2)});
        f(new Object[]{"A", "B"});
        f(new Object[]{new A(), new A()});
    }
}
