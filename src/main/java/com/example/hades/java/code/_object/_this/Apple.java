package com.example.hades.java.code._object._this;

public class Apple {
    private int i = 1;
    private String color;

    public Apple() {
    }

    public Apple(int i) {
        this.i = i;
    }

    public Apple(int i, String color) {
//        this.i = i;
        this(i);
//        this(i);
        this.color = color;
    }

    void print(int a) {
        System.out.println(a);
    }

    void print() {
//        this(i);
        System.out.println(i);
    }

    private Apple increase() {
        i++;
        return this;
    }

    Apple getPeeled() {
        return Peeler.peel(this);
    }

    static class Peeler {
        static Apple peel(Apple apple) {
            apple.i = 100;
            return apple;
        }
    }

    public static void main(String[] args) {
//        Apple apple = new Apple();
        Apple apple = new Apple(10, "Green");
        apple.print(1);

        apple.increase().increase().print();
        apple.getPeeled().print();
    }
}