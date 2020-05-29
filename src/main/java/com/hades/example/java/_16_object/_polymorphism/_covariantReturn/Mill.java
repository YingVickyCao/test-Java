package com.hades.example.java._16_object._polymorphism._covariantReturn;

public class Mill {
    Grain process() {
        return new Grain();
    }
}
