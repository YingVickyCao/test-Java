package com.hades.example.java._16_object._initial_value._2_static._1;

class Counter {
    int i;
    static String name = new String("A");

    public Counter(int i) {
        this.i = i;
        System.out.println("Counter(" + i + ")" + "," + "name=" + name);
        f();
    }

    void f() {
        System.out.println("f(" + i + ")");
    }
}