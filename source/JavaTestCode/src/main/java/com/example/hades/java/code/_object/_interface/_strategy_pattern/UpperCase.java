package com.example.hades.java.code._object._interface._strategy_pattern;

public class UpperCase extends Processor {
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}
