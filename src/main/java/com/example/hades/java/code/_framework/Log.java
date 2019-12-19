package com.example.hades.java.code._framework;

/**
 * Mock Log implementation for testing on non android host.
 */
public final class Log {
    public static void d(String tag, String func, String msg) {
        System.out.println(tag + ":" + "" + func + "," + msg);
    }

    public static void d(String tag, String func, String msg, boolean ignoreTagFuncInfo) {
        if (!ignoreTagFuncInfo) {
            d(tag, func, msg);
            return;
        }
        System.out.println(msg);
    }
}
