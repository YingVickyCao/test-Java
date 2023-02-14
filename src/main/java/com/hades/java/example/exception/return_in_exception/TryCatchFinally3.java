package com.hades.java.example.exception.return_in_exception;

public class TryCatchFinally3 {
    public static void main(String[] args) {
        System.out.println(TryCatchFinally3.test());
    }

    /**
     * try抛出 java.lang.NumberFormatException，所以程序会先执行catch语句中的逻辑.
     * t赋值为catch，在执行return之前，会把返回值保存到一个临时变量t'.
     * 执行finally的逻辑，t赋值为finally，但是返回值和t'，所以变量t的值和返回值已经没有关系了，返回的是catch
     */
    /**
     * ----->try
     * ----->catch
     * ----->finally
     * catch
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
        }
    }
}
