package com.hades.java.example.exception.return_in_exception;

public class TryCatchFinally9 {
    public static void main(String[] args) {
        System.err.println(TryCatchFinally9.test());
    }

    /**
     执行try语句，在返回执行，执行finally语句块，finally语句抛出NullPointerException异常，整个结果返回NullPointerException异常
     */

    /**
     * Exception in thread "main" java.lang.NullPointerException
     * at java.lang.String.<init>(String.java:166)
     * at java.lang.String.valueOf(String.java:3008)
     * at com.hades.java.test.exception.return_in_exception.TryCatchFinally9.test(TryCatchFinally9.java:19)
     * at com.hades.java.test.exception.return_in_exception.TryCatchFinally9.main(TryCatchFinally9.java:5)
     */
    public static String test() {
        String t = "";

        try {
            t = "try";
            return t;
        } catch (Exception e) {
            t = "catch";
            return t;
        } finally {
            t = "finally";
            String.valueOf(null); // NullPointerException
            return t;
        }
    }
}
