package com.example.hades.java.code._object._polymorphism._covariantReturn;

public class Wheat extends Grain {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}