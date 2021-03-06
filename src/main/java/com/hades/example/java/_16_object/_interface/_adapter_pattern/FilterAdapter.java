package com.hades.example.java._16_object._interface._adapter_pattern;

import com.hades.example.java._16_object._interface._strategy_pattern.IProcessor;

public class FilterAdapter implements IProcessor {
    public String name() {
        return getClass().getSimpleName();
    }

    Filter filter;

    public FilterAdapter() {
    }

    public FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform) input) ;
    }
}