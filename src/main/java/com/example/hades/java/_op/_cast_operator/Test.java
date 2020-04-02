package com.example.hades.java._op._cast_operator;

public class Test {
    public static void main(String[] args) {
        int i = 10;
        long l = i;
        long l2 = 20;
        i = (int) l2;

        System.out.println(l);
        System.out.println(l2);
        System.out.println(i);
        System.out.println();

        double above = 0.7, below = 0.4;
        System.out.println((int) above + "," + (int) below);
        System.out.println();

        float fabove = 0.7f, fbelow = 0.4f;
        System.out.println((int) fabove + "," + (int) fbelow);
        System.out.println();

        System.out.println(Math.round(above) + "," + Math.round(below));
        System.out.println(Math.round(fabove) + "," + Math.round(fbelow));
    }
}