package com.hades.example.java._object._overload;

public class PrimitiveOverloading {
    public static void main(String[] args) {
        PrimitiveOverloading test = new PrimitiveOverloading();
        test.testByte();
        System.out.println();

        test.testChar();
        System.out.println();

        test.testShort();
        System.out.println();

        test.testInt();
        System.out.println();

        test.testConstant();
        System.out.println();

        test.testLong();
        System.out.println();

        test.testFloat();
        System.out.println();

        test.testDouble();
        System.out.println();
    }


    private void testConstant() {
        System.out.print("1:  ");
        f1(1);
        f2(1);
        f3(1);
        f4(1);
        f5(1);
        f6(1);
        f7(1);
    }

    private void testByte() {
        System.out.print("byte:");
        byte x = 1;
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
    }

    private void testChar() {
        System.out.print("char:");
        char x = 1;
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
    }

    private void testShort() {
        System.out.print("short:");
        short x = 1;
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
    }

    private void testInt() {
        System.out.print("int:");
        int x = 1;
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
    }

    private void testLong() {
        System.out.print("long:");
        long x = 1;
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
    }

    private void testFloat() {
        System.out.print("float:");
        float x = 1;
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
    }

    private void testDouble() {
        System.out.print("double:");
        double x = 1;
        f1(x);
        f2(x);
        f3(x);
        f4(x);
        f5(x);
        f6(x);
        f7(x);
    }

    private void f1(byte x) {
        System.out.print("f1(byte)   ");
    }

    private void f1(short x) {
        System.out.print("f1(short)   ");
    }

    private void f1(char x) {
        System.out.print("f1(char)   ");
    }

    private void f1(int x) {
        System.out.print("f1(int)   ");
    }

    private void f1(long x) {
        System.out.print("f1(long)   ");
    }

    private void f1(float x) {
        System.out.print("f1(float)   ");
    }

    private void f1(double x) {
        System.out.print("f1(double)   ");
    }

    private void f2(short x) {
        System.out.print("f2(short)   ");
    }

    private void f2(char x) {
        System.out.print("f2(char)   ");
    }

    private void f2(int x) {
        System.out.print("f2(int)   ");
    }

    private void f2(long x) {
        System.out.print("f2(long)   ");
    }

    private void f2(float x) {
        System.out.print("f2(float)   ");
    }

    private void f2(double x) {
        System.out.print("f2(double)   ");
    }

    private void f3(char x) {
        System.out.print("f3(char)   ");
    }

    private void f3(int x) {
        System.out.print("f3(int)   ");
    }

    private void f3(long x) {
        System.out.print("f3(long)   ");
    }

    private void f3(float x) {
        System.out.print("f3(float)   ");
    }

    private void f3(double x) {
        System.out.print("f3(double)   ");
    }

    private void f4(int x) {
        System.out.print("f4(int)   ");
    }

    private void f4(long x) {
        System.out.print("f4(long)   ");
    }

    private void f4(float x) {
        System.out.print("f4(float)   ");
    }

    private void f4(double x) {
        System.out.print("f4(double)   ");
    }

    private void f5(long x) {
        System.out.print("f5(long)   ");
    }

    private void f5(float x) {
        System.out.print("f5(float)   ");
    }

    private void f5(double x) {
        System.out.print("f5(double)   ");
    }


    private void f6(float x) {
        System.out.print("f6(float)   ");
    }

    private void f6(double x) {
        System.out.print("f6(double)   ");
    }

    private void f7(double x) {
        System.out.print("f7(double)   ");
    }
}