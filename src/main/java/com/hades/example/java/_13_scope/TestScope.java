package com.hades.example.java._13_scope;

import com.hades.example.java.lib.Log;

public class TestScope {
    private static final String TAG = TestScope.class.getSimpleName();

    private int num = 20;

    public static void main(String[] args) {
    }

    private void test() {
        int num = 10;
        Log.d(TAG, "test" + String.valueOf(this.num));
        Log.d(TAG, "test" + String.valueOf(num));
        {
            // ERROR:variable is arleady defined in this scope
//            int num = 30;
        }
    }
}
