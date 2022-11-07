package com.hades.java.test.exception.return_in_exception;

import java.security.InvalidParameterException;

public class ReturnInExceptionExample3 {
    public static void main(String[] args) {
        ReturnInExceptionExample3 example = new ReturnInExceptionExample3();
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
        } catch (Exception ex) {
            stu.setName("B");
            System.out.println("--catch," + stu.getName());
            return "return_in_exception value is from catch";
        }
    }

    /**
     * 不抛出 Exception时，当catch有return时。最后结束方法并返回try的return值。
     * <p>
     * try,A
     * return_in_exception value is from try
     */
    private int doSum(int num, int num2) {
        return num + num2;
    }

    /**
     * 当抛出 Exception时，当catch有return时，最后结束方法并返回catch的return值。
     * try,A
     * catch,B
     * return_in_exception value is from catch
     */
//    private int doSum(int num, int num2) throws InvalidParameterException {
//        throw new InvalidParameterException("wrong param");
//    }
}
