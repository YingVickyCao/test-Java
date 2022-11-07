package com.hades.java.test.exception.return_in_exception;

public class TryCatchFinally6 {
    public static void main(String[] args) {
        System.out.println(TryCatchFinally6.test());
    }

    /**
     * finally
     */

    /**
     * 当catch语句块里面抛出异常之后，进入finally语句快，然后返回t。则程序忽略catch语句块里面抛出的异常信息，直接返回t对应的值 也就是finally。方法不会抛出异常
     */
    public static String test() {
        String t = "";
        try {
            t = "try";
            Integer.parseInt(null);
            return t;
        } catch (Exception e) {
            t = "catch";
            Integer.parseInt(null);
            return t;
        } finally {
            t = "finally";
            return t;
        }
    }
}
