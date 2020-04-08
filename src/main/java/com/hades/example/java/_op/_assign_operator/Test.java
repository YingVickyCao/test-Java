package com.hades.example.java._op._assign_operator;

public class Test {
    public static void main(String[] args) {
        Number n1 = new Number();
        Number n2 = new Number();

        n1.i = 1;
        n2.i = 2;
        System.out.println(n1.i + "," + n2.i);

        n1 = n2; // 别名
        System.out.println(n1.i + "," + n2.i);

        n1.i = 100;
        System.out.println(n1.i + "," + n2.i);
    }
}