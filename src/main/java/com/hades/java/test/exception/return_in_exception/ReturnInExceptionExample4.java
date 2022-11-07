package com.hades.java.test.exception.return_in_exception;

import java.security.InvalidParameterException;

public class ReturnInExceptionExample4 {
    public static void main(String[] args) {
        ReturnInExceptionExample4 example = new ReturnInExceptionExample4();
        example.test_return_in_try_catch_finally();
    }

    private void test_return_in_try_catch_finally() {
        String result = sum(1, 3);
        System.out.println(result);
    }

    /**

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
            return "return_in_exception value is from catch";
        } finally {
            stu.setName("C");
            System.out.println("--finally," + stu.getName());
            System.exit(0);
        }
    }


    /**
     * 不抛出 Exception时，当catch有return、finally没有return时，finally执行System.exit(0)将退出整个程序，不再返回return值。。
     *
     *--try,A
     * --finally,C
     */
//    private int doSum(int num, int num2) {
//        return num + num2;
//    }

    /**
     * 抛出 Exception时，当catch有return、finally没有return时，finally执行System.exit(0)将退出整个程序，不再返回return值。。
     *
     *
     * --try,A
     * --catch,B
     * --finally,C
     */
    private int doSum(int num, int num2) throws InvalidParameterException {
        throw new InvalidParameterException("wrong param");
    }
}
