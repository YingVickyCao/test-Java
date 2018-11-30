package com.example.hades.java.code._primitive_type;

import com.example.hades.java.code.framework.Log;

public class TestPrimitiveType {
    private static final String TAG = TestPrimitiveType.class.getSimpleName();

    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        Log.d(TAG, "main", "max=" + max + ",min=" + min);
    }
}
