package com.example.hades.java.code._object._interface._strategy_pattern;

public abstract class Processor implements IProcessor {
    public String name() {
        return getClass().getSimpleName();
    }

    public abstract Object process(Object input);
}
