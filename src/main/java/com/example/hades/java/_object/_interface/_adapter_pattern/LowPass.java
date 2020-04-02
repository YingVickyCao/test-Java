package com.example.hades.java._object._interface._adapter_pattern;

public class LowPass extends Filter {
    double d;

    public LowPass(double d) {
        this.d = d;
    }

    public Waveform process(Waveform input) {
        return input;
    }
}
