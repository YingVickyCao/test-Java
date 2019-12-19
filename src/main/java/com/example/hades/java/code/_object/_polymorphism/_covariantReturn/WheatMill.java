package com.example.hades.java.code._object._polymorphism._covariantReturn;

public class WheatMill extends Mill {
    Wheat process() {
        return new Wheat();
    }
}
