package com.example.hades.java.code._op._shift_operator;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.shiftInt();
    }

    private void shiftInt() {
        int i = -1;
        System.out.println(Integer.toBinaryString(i) + "," + i);
        i <<= 2;
        System.out.println(Integer.toBinaryString(i) + "," + i);

        int j = 2;
        System.out.println(Integer.toBinaryString(j) + "," + j);
        j >>= 3;
        System.out.println(Integer.toBinaryString(j) + "," + j);
    }
}
