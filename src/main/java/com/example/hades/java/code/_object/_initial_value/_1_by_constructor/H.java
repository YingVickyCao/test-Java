package com.example.hades.java.code._object._initial_value._1_by_constructor;

class H {
    W w1 = new W(1);

    H() {
        System.out.println("H()--------->");
        w3 = new W(31);
        System.out.println("H()<---------");
    }

    W w3 = new W(3);

    W w2 = new W(2);

    void f() {
        System.out.println("void f()");
    }

    int getInt(int num) {
        return num;
    }

    W w4 = new W(getInt(4));
}