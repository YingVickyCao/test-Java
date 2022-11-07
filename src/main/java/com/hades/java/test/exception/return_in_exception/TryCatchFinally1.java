package com.hades.java.test.exception.return_in_exception;

public class TryCatchFinally1 {
    public static void main(String[] args) {
        String result = TryCatchFinally1.test();
        System.out.println(result);
    }

    /**
     * 在try语句 中遇到return，java 会创建一个临时变量空间来存储新的临时变量t'，并把值try 拷贝进去。
     * 即使在finally语句中把引用t指向了值finally，因为return的返回引用已经不是t ，所以引用t的对应的值和try语句中的返回值无关了。
     */
    /**
     * ---->try
     * ---->finally
     * try
     */
    public static final String test() {
        String t = "";

        try {
            System.out.println("---->try");
            t = "try";
            return t;
        } catch (Exception e) {
            System.out.println("---->catch");
            t = "catch";
            return t;
        } finally {
            System.out.println("---->finally");
            t = "finally";
        }
    }
}
