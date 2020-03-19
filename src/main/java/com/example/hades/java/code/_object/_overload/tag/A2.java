package com.example.hades.java.code._object._overload.tag;

public class A2 extends A1 {
    public static String TAG1 = A2.class.getSimpleName();
    public static String TAG2 = A2.class.getCanonicalName();

    public String getTag2() {
        return TAG2;
    }
}
