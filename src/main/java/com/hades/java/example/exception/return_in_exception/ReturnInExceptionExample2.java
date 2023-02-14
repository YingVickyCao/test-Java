package com.hades.java.example.exception.return_in_exception;

import java.security.InvalidParameterException;

public class ReturnInExceptionExample2 {
    public static void main(String[] args) {
        ReturnInExceptionExample2 example = new ReturnInExceptionExample2();
        example.test_return_in_try_catch_finally();
    }

    private void test_return_in_try_catch_finally() {
        String result = sum(1, 3);
        System.out.println(result);
    }

    /**
     * 不抛出 Exception时，当catch有return、finally没有return时，先执行catch，再执行finally内容。最后结束方法并返回try的return值。
     * <p>
     * --try,A
     * --finally,C
     * return_in_exception value is from try : A
     */
    private String sum(int num, int num2) {
        Stu stu = new Stu("A");
        try {
            System.out.println("--try," + stu.getName());
            doSum(1, 2);
            return "return_in_exception value is from try:" + stu.getName();
        } catch (Exception ex) {
            stu.setName("B");
            System.out.println("--catch," + stu.getName());
            return "return_in_exception value is from catch:" + stu.getName();
        } finally {
            stu.setName("C");
            System.out.println("--finally," + stu.getName());
        }
    }

//    private int doSum(int num, int num2) {
//        return num + num2;
//    }

    /**
     * 当抛出 Exception时，当catch有return、finally没有return时，先执行catch，再执行finally内容。最后结束方法并返回try的return值。
     *
     --try,A
     --finally,C
     return_in_exception value is from try : B
     */
    private int doSum(int num, int num2) throws InvalidParameterException {
        throw new InvalidParameterException("wrong param");
    }
}
