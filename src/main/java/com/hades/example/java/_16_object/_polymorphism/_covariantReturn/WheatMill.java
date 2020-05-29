package com.hades.example.java._16_object._polymorphism._covariantReturn;

public class WheatMill extends Mill {
    Wheat process() {
        return new Wheat();
    }
}
