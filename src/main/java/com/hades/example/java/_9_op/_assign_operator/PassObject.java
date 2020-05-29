package com.hades.example.java._9_op._assign_operator;

public class PassObject {
    static void f(Number y) {// 别名
        System.out.println("Num@" + y.hashCode() + ":" + y.i);
        y.i = 20;
    }

    public static void main(String[] args) {
        Number x = new Number();
        x.i = 10;
        System.out.println("Num@" + x.hashCode() + ":" + x.i);

        f(x);
        System.out.println("Num@" + x.hashCode() + ":" + x.i);
    }
}
