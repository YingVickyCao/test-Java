package com.hades.java.test.exception;

public class ThrowExceptionExample3 {
    public static void main(String[] args) {

        try {
            ThrowExceptionExample3.test();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 自定义异常抛出不要丢掉原始的Throwable cause 信息
     */
    private static void test() throws MyException {
        try {
            int[] nums = {2, 3};
            int data = nums[3]; // ArrayIndexOutOfBoundsException
            System.out.println(data);
        } catch (Exception exception) {
            /**
             * com.hades.java.test.exception.MyException: accessed array index is out of bonds
             * 	at com.hades.java.test.exception.ThrowExceptionExample3.test(ThrowExceptionExample3.java:22)
             * 	at com.hades.java.test.exception.ThrowExceptionExample3.main(ThrowExceptionExample3.java:7)
             */
            // bad
//            throw new MyException("accessed array index is out of bonds");
            /**
             * com.hades.java.test.exception.MyException: accessed array index is out of bonds
             * 	at com.hades.java.test.exception.ThrowExceptionExample3.test(ThrowExceptionExample3.java:26)
             * 	at com.hades.java.test.exception.ThrowExceptionExample3.main(ThrowExceptionExample3.java:7)
             * Caused by: java.lang.ArrayIndexOutOfBoundsException: 3
             * 	at com.hades.java.test.exception.ThrowExceptionExample3.test(ThrowExceptionExample3.java:16)
             */
            // good
            throw new MyException("accessed array index is out of bonds", exception);
        }
    }
}
