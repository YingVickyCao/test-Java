package com.hades.java.test.exception.return_in_exception;

public class TryCatchFinally8 {
    public static void main(String[] args) {
        System.err.println(TryCatchFinally8.test());
    }

    /**
     * catch 捕捉的是NullPointerException，不是NumberFormatException。
     * try语句执行完成执行finally语句，finally赋值s。finally 有返回s，忽略抛出异常不是NumberFormatException，最后结果返回finally
     */
    /**
     * ---->try
     * ---->finally
     * finally
     */
    public static String test() {
        String t = "";

        try {
            System.out.println("---->try");
            t = "try";
            Integer.parseInt(null); // NumberFormatException
            return t;
        } catch (NullPointerException e) {
            System.out.println("---->catch");
            t = "catch";
            return t;
        } finally {
            System.out.println("---->finally");
            t = "finally";
            return t;
        }
    }
}
