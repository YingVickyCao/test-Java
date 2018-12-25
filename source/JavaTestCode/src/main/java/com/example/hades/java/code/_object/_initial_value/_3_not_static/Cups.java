package com.example.hades.java.code._object._initial_value._3_not_static;

public class Cups {
    int num = 97;
    Cup cup1 = new Cup(11);
    Cup cup2 = new Cup(21);

    {
        System.out.println("----init--->");
        System.out.println("num:" + num);
        System.out.println(cup1.toString());
        System.out.println(cup2.toString());

        num = 98;
        cup1 = new Cup(12);
        cup2 = new Cup(22);
        System.out.println("num:" + num);
        System.out.println(cup1.toString());
        System.out.println(cup2.toString());

        System.out.println("<----init---");
    }

    public Cups() {
        num = 98;
        System.out.println("Cups(),num=" + num);
    }

    public Cups(int n) {
        System.out.println("Cups(" + n + "),num=" + num);
    }
}
