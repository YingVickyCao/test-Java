package com.hades.java.example.exception;

public class CatchExample {
    public static void main(String[] args) {
        CatchExample example = new CatchExample();
        example.test();
    }

    private void test() {
        try {
//            throw new InvalidParameterException(); // InvalidParameterException
            Integer.parseInt(null); // NumberFormatException
        } catch (Exception ex) {
            /**
             * 推荐：
             * java.lang.NumberFormatException: null
             */
//            System.out.println(ex);
            /**
             * 不推荐：信息太短，不方便调试
             * null
             */
            System.out.println(ex.getMessage());

            /**
             * 不推荐：假如信息太多，log太多，也浪费内存。
             * java.lang.NumberFormatException: null
             * 	at java.lang.Integer.parseInt(Integer.java:542)
             * 	at java.lang.Integer.parseInt(Integer.java:615)
             * 	at com.hades.java.test.exception.CatchExample.test(CatchExample.java:14)
             * 	at com.hades.java.test.exception.CatchExample.main(CatchExample.java:8)
             */
//            ex.printStackTrace();
        }
    }

}