package com.hades.example.java._16_object._interface;

import com.hades.example.java._16_object._interface._strategy_pattern.IProcessor;

public class Apply {
    // 策略 = Processor = 变化部分
//    public static void process(Processor p, Object s) {
    public static void process(IProcessor p, Object s) {
        System.out.println(p.name());
        System.out.println(p.process(s));
        System.out.println();
    }
}