package com.example.hades.java._object._polymorphism._covariantReturn;

public class WheatMill extends Mill {
    Wheat process() {
        return new Wheat();
    }
}
