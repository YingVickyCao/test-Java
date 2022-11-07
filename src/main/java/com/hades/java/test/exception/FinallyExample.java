package com.hades.java.test.exception;

import java.security.InvalidParameterException;

public class FinallyExample {
    int count = 0;

    public static void main(String[] args) {
        FinallyExample example = new FinallyExample();
        example.test_depressed();
        example.test_recommended();
    }

    /**
     * finally：
     * 把资源释放或状态还原的代码放到finally块，否则每个catch 语句都要设置它们。
     */
    private void test_depressed() {
        count = 0; //初始化资源
        try {
            count++;
            // do something
            sum(1, 3);
            minus(2, 5);
        } catch (InvalidParameterException ex) {
            count = 0; // 状态还原
            System.out.println(ex);
        } catch (NullPointerException ex) {
            count = 0; // 状态还原
            System.out.println(ex);
        } catch (Exception ex) {
            count = 0; // 状态还原
            System.out.println(ex);
        }
    }

    private void test_recommended() {
        count = 0; //初始化资源
        try {
            count++;
            // do something
            sum(1, 3);
            minus(2, 5);
        } catch (InvalidParameterException | NullPointerException ex) {
            System.out.println(ex);
        }
        // or
//        catch (InvalidParameterException ex) {
//            System.out.println(ex);
//        } catch (NullPointerException ex) {
//            System.out.println(ex);
//        }
        catch (Exception ex) {
            System.out.println(ex);
        } finally {
            count = 0; // 状态还原
        }
    }

    private void sum(int num1, int num2) throws InvalidParameterException {
        System.out.println(num1 + num2);
    }

    private void minus(int num1, int num2) throws NullPointerException {
        System.out.println(num1 - num2);
    }
}
