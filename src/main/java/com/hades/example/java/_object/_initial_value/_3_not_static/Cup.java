package com.hades.example.java._object._initial_value._3_not_static;

public class Cup {
    int n;

    Cup(int n) {
        System.out.println("Cup(" + n + ")");
        this.n = n;
    }

    void f(int n) {
        System.out.println("f(" + n + ")");
        this.n = n;
    }

    @Override
    public String toString() {
        return "Cup{" +
                "n=" + n +
                '}';
    }
}
