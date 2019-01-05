package com.example.hades.java.code._object._polymorphism._static_method;

public class Base {
    private static final String TAG = Base.class.getSimpleName();

    public static String staticGet() {
        return TAG + ".staticGet()";
    }

    public String dynamicGet() {
        return TAG + ".dynamicGet()";
    }
}
