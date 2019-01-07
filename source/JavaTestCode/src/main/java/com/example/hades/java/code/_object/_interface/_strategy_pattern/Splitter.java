package com.example.hades.java.code._object._interface._strategy_pattern;

import java.util.Arrays;

public class Splitter extends Processor {
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}