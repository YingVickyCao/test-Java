package com.hades.java.test.exception.return_in_exception;

public class TryCatchFinally5 {
    public static void main(String[] args) {
        System.out.println(TryCatchFinally5.test());
    }

    /**
     * Exception in thread "main" java.lang.NumberFormatException: null
     * 	at java.lang.Integer.parseInt(Integer.java:542)
     * 	at java.lang.Integer.parseInt(Integer.java:615)
     * 	at com.hades.java.test.exception.return_in_exception.ReturnInExceptionExample2_Simple3.test(ReturnInExceptionExample2_Simple3.java:16)
     * 	at com.hades.java.test.exception.return_in_exception.ReturnInExceptionExample2_Simple3.main(ReturnInExceptionExample2_Simple3.java:5)
     */
    /**
     * 这个例子在catch语句块添加了Integer.parser(null)语句，强制抛出了一个异常。然后finally语句块里面没有return语句。
     * 继续分析一下，由于try语句抛出异常，程序进入catch语句块，catch语句块又抛出一个异常，说明catch语句要退出，则执行finally语句块，对t进行赋值。
     * 然后catch语句块里面抛出异常。结果是抛出java.lang.NumberFormatException异常
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
            //return t;
        }
    }
}
