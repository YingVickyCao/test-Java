package com.example.hades.java.code._op._arithmetic;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
//        arithmeticOperator();

//        preIncrement();
//        postIncrement();

        relationalOperator();
    }

    static void pInt(String s, int i) {
        prt(s + " = " + i);
    }

    static void prt(String s) {
        System.out.println(s);
    }

    static void pFlt(String s, float f) {
        prt(s + " = " + f);
    }

    private static void arithmeticOperator() {
        Random rand = new Random();

        int i, j, k;
        j = rand.nextInt() % 100; // max = 99
        k = rand.nextInt() % 100;
        System.out.println(j + "," + k);
        System.out.println();

        i = j + k;
        pInt("j + k", i);
        i = j - k;
        pInt("j - k", i);
        i = k / j;
        pInt("k / j", i);// ERROR:Exception in thread "main" java.lang.ArithmeticException: / by zero
        i = k * j;
        pInt("k * j", i);
        i = k % j;
        pInt("k % j", i);
        j %= k;
        pInt("j %= k", j);
        System.out.println();

        float u, v, w;
        v = rand.nextFloat();
        w = rand.nextFloat();
        pFlt("v", v);
        pFlt("w", w);
        u = v + w;
        pFlt("v + w", u);
        u = v - w;
        pFlt("v - w", u);
        u = v * w;
        pFlt("v * w", u);
        u = v / w;
        pFlt("v / w", u);
        System.out.println();

        int x = 100;
        int a = -5;
        x = -a; // 一元减
        System.out.println(x);
        x = +a; // 一元加
        System.out.println(x);
    }

    private static void preIncrement() {
        System.out.println();
        int m = 10;
        System.out.println(m);
        System.out.println(++m);
        System.out.println(m);
    }

    private static void postIncrement() {
        System.out.println();
        int n = 30;
        System.out.println(n);
        System.out.println(n++);
        System.out.println(n);
    }

    private static void relationalOperator() {
        // 对象的内容相同，但引用不同
        Integer n1 = new Integer(47);
        Integer n2 = new Integer(47);
        System.out.println(n1 == n2);
        System.out.println(n1 != n2);
        System.out.println();

        System.out.println(n1.equals(n2));
        System.out.println();

        Value v1 = new Value();
        Value v2 = new Value();
        v1.i = v2.i = 100;
        // 重写equals()前：false，后true
        System.out.println(v1.equals(v2));
    }
}
