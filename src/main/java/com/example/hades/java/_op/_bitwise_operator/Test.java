package com.example.hades.java._op._bitwise_operator;

public class Test {
    private int num1 = 1;
    private int num2 = 2;
    private int num3 = 3;

    public static void main(String[] args) {
        new Test().test();
    }

    public void test() {
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println((num1 & num2) + "," + (num1 & num3));
        System.out.println((num1 | num2) + "," + (num1 | num3));
        System.out.println((num1 ^ num2) + "," + (num1 ^ num3));
        System.out.println((~num1) + "," + (~num2) + "," + (~num3));// 补码  -> 十进制
    }
}