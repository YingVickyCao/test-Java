package com.hades.example.java._object._polymorphism._static_method;

public class Derived extends Base {
    private static final String TAG = Derived.class.getSimpleName();

    public static String staticGet() {
        return TAG + ".staticGet()";
    }

    public String dynamicGet() {
        return TAG + ".dynamicGet()";
    }
}
