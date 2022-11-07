package com.hades.java.test.exception.return_in_exception;

public class TryCatchFinally7 {
    public static void main(String[] args) {
        System.out.println(TryCatchFinally7.test());
    }

    /**
     * catch语句里面catch的是NPE异常，而不是java.lang.NumberFormatException异常，所以不会进入catch语句块，直接进入finally语句块，finally对s赋值之后，由try语句抛出java.lang.NumberFormatException异常
     */
    /**
     * ----->try
     * ----->finally
     * Exception in thread "main" java.lang.NumberFormatException: null
     * at java.lang.Integer.parseInt(Integer.java:542)
     * at java.lang.Integer.parseInt(Integer.java:615)
     * at com.hades.java.test.exception.return_in_exception.TryCatchFinally7.test(TryCatchFinally7.java:14)
     * at com.hades.java.test.exception.return_in_exception.TryCatchFinally7.main(TryCatchFinally7.java:5)
     */
    public static String test() {
        String t = "";

        try {
            System.out.println("----->try");
            t = "try";
            Integer.parseInt(null);
            return t;
        } catch (NullPointerException e) {
            System.out.println("----->catch");
            t = "catch";
            return t;
        } finally {
            System.out.println("----->finally");
            t = "finally";
        }
    }
}
