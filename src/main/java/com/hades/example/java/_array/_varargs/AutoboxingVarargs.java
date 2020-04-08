package com.hades.example.java._array._varargs;

public class AutoboxingVarargs {
    public static void main(String[] args) {
        f(new Integer(1),new Integer(2));
        f(3,4);
        f(5,new Integer(6)); // autoboxing, i -> integer
    }

    public static void f(Integer... args) {
        for (Integer item : args) {
            System.out.print(item + "  ");
        }
        System.out.println();
    }
}
