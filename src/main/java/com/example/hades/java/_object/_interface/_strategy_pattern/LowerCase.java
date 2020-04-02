package com.example.hades.java._object._interface._strategy_pattern;

public class LowerCase extends Processor {
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}
