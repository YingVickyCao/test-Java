package com.example.hades.java.code._static;

public class Test {
    public static void main(String[] args) {
        if (0 != args.length) {
            for (int i = 0; i < args.length; i++) {
                System.out.println("args[" + i + "]=" + args[i]);
            }
        } else {
            System.out.println("Command Line is Empty!");
        }

        System.out.println(StaticClass.num);//10
        StaticClass.num = 20;
        System.out.println(StaticClass.num);//20
        System.out.println();

        StaticClass s1 = new StaticClass();
        StaticClass s2 = new StaticClass();

        System.out.println(StaticClass.num);//20
        System.out.println(s1.num);//20
        System.out.println(s2.num);//20
        System.out.println();

        StaticClass.num += 30;
        System.out.println(StaticClass.num);//50
        System.out.println(s1.num);//50
        System.out.println(s2.num);//50
        System.out.println();

        StaticClass.increment();
        System.out.println(StaticClass.num);//51
        System.out.println(s1.num);//51
        System.out.println(s2.num);//51
        System.out.println();

        s1.increment();
        System.out.println(StaticClass.num);//52
        System.out.println(s1.num);//52
        System.out.println(s2.num);//52
    }
}
/*
    java  com.example.hades.java.code._static.Test 10 20 30

    args[0]=10
    args[1]=20
    args[2]=30
    10
    20

    20
    20
    20

    50
    50
    50

    51
    51
    51

    52
    52
    52
*/
