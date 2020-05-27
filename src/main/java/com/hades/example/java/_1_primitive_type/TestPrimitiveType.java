package com.hades.example.java._1_primitive_type;

public class TestPrimitiveType {
    private static final String TAG = TestPrimitiveType.class.getSimpleName();

    int a;
    double b;
    boolean c;
    char d;
    float f;
    byte e;
    long h;
    short j;
    Integer reference;

    public static void main(String[] args) {
        TestPrimitiveType test = new TestPrimitiveType();
        test.defaultValue4PrimitiveType();
        test.defaultValue4Class();
        test.setValue();
    }

    private void defaultValue4PrimitiveType() {
        System.out.println("布尔型的默认值是：" + c);
        System.out.println("byte的默认值是：" + e);
        System.out.println("字符型的默认值是：" + d);
        System.out.println("短整型的默认值是：" + j);
        System.out.println("整型的默认值是：" + a);
        System.out.println("长整型的默认值是：" + h);
        System.out.println("单精度浮点型的默认值是：" + f);
        System.out.println("双精度浮点型的默认值是：" + b);
    }

    private void defaultValue4Class() {
        if (reference == null) {
            System.out.println("class的默认值是：null");
        }
    }

    private void setValue(){
        // [-128, 127]
        byte v0 = (byte) -129;  //  127
        byte v1 = -128;         // -128
        byte v2 = -127;         // -127
        byte v4 = 127;          // 127
        byte v5 = (byte) 128;   // -128
        System.out.println(v0);
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v4);
        System.out.println(v5);
    }
}
