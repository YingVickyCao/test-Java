package com.hades.example.java._16_object._overload._tag;

public class A1 {
    public static String TAG1 = A1.class.getSimpleName();
    public static String TAG2 = A1.class.getCanonicalName();

    public String getTag1() {
        return TAG1;
    }

    public String getTag2() {
        return TAG2;
    }
}
