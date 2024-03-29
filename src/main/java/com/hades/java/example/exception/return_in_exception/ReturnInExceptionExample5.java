package com.hades.java.example.exception.return_in_exception;

import java.security.InvalidParameterException;

public class ReturnInExceptionExample5 {
    public static void main(String[] args) {
        ReturnInExceptionExample5 example = new ReturnInExceptionExample5();
        example.test_return_in_try_catch_finally();
    }

    private void test_return_in_try_catch_finally() {
        String result = sum(1, 3);
        System.out.println(result);
    }

    /**
     *
     */
    private String sum(int num, int num2) {
        Stu stu = new Stu("A");
        try {
            System.out.println("--try," + stu.getName());
            doSum(1, 2);
            return "return_in_exception value is from try";
        } catch (Exception ex) {
            stu.setName("B");
            System.out.println("--catch," + stu.getName());
        } finally {
            stu.setName("C");
            System.out.println("--finally," + stu.getName());
            return "return_in_exception value is from finally";
        }
    }


    // case 1

    /**
     * 不抛出 Exception时，当catch没有return、finally也有return时，finally 能执行完。最后结束方法并返回finally的return值。
     *
     * --try,A
     * --finally,C
     * return_in_exception value is from finally
     */
//    private int doSum(int num, int num2) {
//        return num + num2;
//    }

    /**
     * 当抛出 Exception时，当catch没有return、finally也有return时，finally 能执行完。最后结束方法并返回finally的return值。
     *
     *
     * --try,A
     * --catch,B
     * --finally,C
     * return_in_exception value is from finally
     */
    private int doSum(int num, int num2) throws InvalidParameterException {
        throw new InvalidParameterException("wrong param");
    }
}
