package com.example.hades.java.code._primitive_type;

import com.example.hades.java.code.framework.Log;

public class TestWrapperClass {
    private static final String TAG = TestWrapperClass.class.getSimpleName();

    public static void main(String[] args) {
        int a = 5;
        Integer integer = a;
        Integer integer2 = 5;
        Integer integer3 = new Integer(5);

        Log.d(TAG, "main", "integer=" + integer);
        Log.d(TAG, "main", "integer2=" + integer2);
        Log.d(TAG, "main", "integer3=" + integer3);

        Log.d(TAG, "main", "char min=" + Character.MIN_VALUE);
        Log.d(TAG, "main", "char max=" + Character.MAX_VALUE);

        Log.d(TAG, "main", "float min=" + Float.MIN_VALUE);//1.4E-45
        Log.d(TAG, "main", "float max=" + Float.MAX_VALUE);//3.4028235E38

        Log.d(TAG, "main", "double min=" + Double.MIN_VALUE);//4.9E-324
        Log.d(TAG, "main", "double max=" + Double.MAX_VALUE);//1.7976931348623157E308
    }
}