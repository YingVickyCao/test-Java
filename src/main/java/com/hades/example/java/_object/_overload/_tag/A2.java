package com.hades.example.java._object._overload._tag;

public class A2 extends A1 {
    public static String TAG1 = A2.class.getSimpleName();
    public static String TAG2 = A2.class.getCanonicalName();

    public String getTag2() {
        return TAG2;
    }
}
