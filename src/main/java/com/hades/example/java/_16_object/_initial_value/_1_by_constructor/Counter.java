package com.hades.example.java._16_object._initial_value._1_by_constructor;

class Counter {
    int i = 1;

    public Counter(int i) {
        this.i = i;
        System.out.println("Counter(" + i + ")");
        f();
    }

    void f() {
        System.out.println("f(" + i + ")");
    }
}