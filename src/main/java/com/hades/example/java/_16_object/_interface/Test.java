package com.hades.example.java._16_object._interface;

import com.hades.example.java._16_object._interface._adapter_pattern.FilterAdapter;
import com.hades.example.java._16_object._interface._adapter_pattern.LowPass;
import com.hades.example.java._16_object._interface._adapter_pattern.Waveform;
import com.hades.example.java._16_object._interface._strategy_pattern.LowerCase;
import com.hades.example.java._16_object._interface._strategy_pattern.Splitter;
import com.hades.example.java._16_object._interface._strategy_pattern.UpperCase;

public class Test {
    public static void main(String[] args) {
        String s = "This is a Hello World";

        Apply.process(new UpperCase(), s);
        Apply.process(new LowerCase(), s);
        Apply.process(new Splitter(), s);


        Waveform waveform = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0d)),waveform);

        Waveform waveform2 = new Waveform();
        Apply.process(new FilterAdapter(new LowPass(2.0d)),waveform2);
    }
}