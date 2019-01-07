package com.example.hades.java.code._object._interface._adapter_pattern;

public class Waveform {
    private static int counter;
    private final int id = counter++;

    public String toString() {
        return "Waveform " + id;
    }
}