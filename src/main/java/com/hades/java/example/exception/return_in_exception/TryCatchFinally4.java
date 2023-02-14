package com.hades.java.example.exception.return_in_exception;

public class TryCatchFinally4 {
    public static void main(String[] args) {
        String result = TryCatchFinally4.test();
        System.err.println(result);
    }

    /**
     * try 遇到return 语句，copy try 值到新建临时变量t1指向新开辟的临时空间space1。然后跳转到finally。
     * finally t指向finally，遇到return 语句，copy finally 值到新建临时变量t2指向新开辟的临时空间space2。最后返回t2的值即finally。
     */
    /**
     * ----->try
     * ----->finally
     * finally
     */
    public static String test() {
        String t = "";

        try {
            System.out.println("----->try");
            t = "try";
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
