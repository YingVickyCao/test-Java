package com.example.hades.java.code._static;

public class Test {
    public static void main(String[] args) {
        /*
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
        System.out.println(StaticClass.num);
        StaticClass.num = 20;
        System.out.println(StaticClass.num);
        System.out.println();

        StaticClass s1 = new StaticClass();
        StaticClass s2 = new StaticClass();

        System.out.println(StaticClass.num);
        System.out.println(s1.num);
        System.out.println(s2.num);
        System.out.println();

        StaticClass.num += 30;
        System.out.println(StaticClass.num);
        System.out.println(s1.num);
        System.out.println(s2.num);
        System.out.println();

        StaticClass.increment();
        System.out.println(StaticClass.num);
        System.out.println(s1.num);
        System.out.println(s2.num);
        System.out.println();

        s1.increment();
        System.out.println(StaticClass.num);
        System.out.println(s1.num);
        System.out.println(s2.num);
    }
}
