package com.hades.java.test.exception.return_in_exception;

public class TryCatchFinally2 {
    public static void main(String[] args) {
        System.out.println(TryCatchFinally2.test());
    }


    /**
     * 由于try语句里面抛出异常，程序转入catch语句块，catch语句在执行return语句之前执行finally，而finally语句有return,则直接执行finally的语句值，返回finally
     */
    /**
     * ----->try
     * ----->catch
     * ----->finally
     * finally
     *
     * @return
     */
    public static final String test() {
        String t = "";

        try {
            System.out.println("----->try");
            t = "try";
            Integer.parseInt(null); // NumberFormatException
            return t;
        } catch (Exception e) {
            System.out.println("----->catch");
            t = "catch";
            return t;
        } finally {
            System.out.println("----->finally");
            t = "finally";
            return t;
        }
    }
}
