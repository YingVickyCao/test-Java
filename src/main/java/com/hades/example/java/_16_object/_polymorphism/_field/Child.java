package com.hades.example.java._16_object._polymorphism._field;

public class Child extends Parent {
    public int i = 2;

    public int getI() {
        return i;
    }

    public int getSuperI() {
        return super.i;
    }
}