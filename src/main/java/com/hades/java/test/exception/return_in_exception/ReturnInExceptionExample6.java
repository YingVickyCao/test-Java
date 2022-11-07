package com.hades.java.test.exception.return_in_exception;

import java.security.InvalidParameterException;

public class ReturnInExceptionExample6 {
    public static void main(String[] args) {
        ReturnInExceptionExample6 example = new ReturnInExceptionExample6();
        example.test_return_in_try_catch_finally();
    }

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
        } finally {
            stu.setName("C");
            System.out.println("--finally," + stu.getName());
        }
    }


    // case 1

    /**
     * 不抛出 Exception时，只有finally时，finally 能执行完并结束方法、返回try的值。
     *
     * --try,A
     * --finally,C
     */
//    private int doSum(int num, int num2) {
//        return num + num2;
//    }

    /**
     * 抛出 Exception时，只有finally时，finally 能执行完并结束方法、抛出Exception。
     * <p>
     * --try,A
     * --finally,C
     * Exception in thread "main" java.security.InvalidParameterException: wrong param
     * at com.hades.java.test.exception.return_in_exception.ReturnInExceptionExample6.doSum(ReturnInExceptionExample6.java:55)
     * at com.hades.java.test.exception.return_in_exception.ReturnInExceptionExample6.sum(ReturnInExceptionExample6.java:23)
     * at com.hades.java.test.exception.return_in_exception.ReturnInExceptionExample6.test_return_in_try_catch_finally(ReturnInExceptionExample6.java:12)
     * at com.hades.java.test.exception.return_in_exception.ReturnInExceptionExample6.main(ReturnInExceptionExample6.java:8)
     */
    private int doSum(int num, int num2) throws InvalidParameterException {
        throw new InvalidParameterException("wrong param");
    }
}
