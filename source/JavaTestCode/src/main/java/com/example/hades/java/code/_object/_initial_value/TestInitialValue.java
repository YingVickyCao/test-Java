package com.example.hades.java.code._object._initial_value;


public class TestInitialValue {
    int n = getNum(a); // ERROR:向前引用错误 illegal forward reference
    int a = 100;
    int a2 = getInt();
    int a3 = getInt(100);
    double b = 0.5d;
    boolean c = true;
    char d = 'd';
    float f = 1.0f;
    byte e = 15;
    long h = 102L;
    short j = 5;
    Integer reference = 5;
    Integer reference2 = new Integer("5");

    public static void main(String[] args) {
        TestInitialValue test = new TestInitialValue();
        test.initValue4PrimitiveType();
        test.initValue4Class();
    }

    private void initValue4PrimitiveType() {
        System.out.println("布尔型的初始化值是：" + c);
        System.out.println("byte的初始化值是：" + e);
        System.out.println("字符型的初始化值是：" + d);
        System.out.println("短整型的初始化值是：" + j);
        System.out.println("整型的初始化值是：" + a + "," + a2 + "," + a3);
        System.out.println("长整型的初始化值是：" + h);
        System.out.println("单精度浮点型的初始化值是：" + f);
        System.out.println("双精度浮点型的初始化值是：" + b);
    }

    private int getInt() {
        return 100;
    }

    private int getInt(int num) {
        return num;
    }

    private int getNum(int num) {
        return num * 10;
    }
    private void initValue4Class() {
        if (reference == null) {
            System.out.println("class的初始化值是：null");
        } else {
            System.out.println("class的初始化值是：" + reference);
        }

        if (reference2 == null) {
            System.out.println("class的初始化值是：null");
        } else {
            System.out.println("class的初始化值是：" + reference2);
        }
    }
}
