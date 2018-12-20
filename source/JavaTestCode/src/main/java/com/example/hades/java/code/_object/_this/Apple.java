package com.example.hades.java.code._object._this;

public class Apple {
    int i = 1;

    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.print(1);

        apple.increase().increase().print();
        apple.getPeeled().print();
    }

    void print(int a) {
        System.out.println(a);
    }

    void print() {
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


}