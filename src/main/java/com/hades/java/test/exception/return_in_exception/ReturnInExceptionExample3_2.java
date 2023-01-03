package com.hades.java.test.exception.return_in_exception;

import java.security.InvalidParameterException;

public class ReturnInExceptionExample3_2 {
    public static void main(String[] args) {
        ReturnInExceptionExample3_2 example = new ReturnInExceptionExample3_2();
        example.test_return_in_try_catch_finally();
    }

    /**
     * --try,A
     * Exception in thread "main" --catch,B
     * java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 2
     * 	at com.hades.java.test.exception.return_in_exception.ReturnInExceptionExample3_2.sum(ReturnInExceptionExample3_2.java:27)
     * 	at com.hades.java.test.exception.return_in_exception.ReturnInExceptionExample3_2.test_return_in_try_catch_finally(ReturnInExceptionExample3_2.java:12)
     * 	at com.hades.java.test.exception.return_in_exception.ReturnInExceptionExample3_2.main(ReturnInExceptionExample3_2.java:8)
     */
    // 当catch 中 有 Exception时，因为catch中没有不活，一样会crash
    private void test_return_in_try_catch_finally() {
        String result = sum(1, 3);
        System.out.println(result);
    }

    private String sum(int num, int num2) {
        Stu stu = new Stu("A");
        try {
            System.out.println("--try," + stu.getName());
            doSum(1, 2);
            return "return_in_exception value is from try";
        } catch (Exception ex) {
            stu.setName("B");
            System.out.println("--catch," + stu.getName());
            int[] array = new int[2];
            int n = array.length+2;
            int data = array[n]; // ArrayIndexOutOfBoundsException
            System.out.println(data);
            return "return_in_exception value is from catch";
        }
    }
    private int doSum(int num, int num2) throws InvalidParameterException {
        throw new InvalidParameterException("wrong param");
    }
}
