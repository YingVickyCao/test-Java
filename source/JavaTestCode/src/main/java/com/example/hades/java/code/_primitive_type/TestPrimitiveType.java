package com.example.hades.java.code._primitive_type;

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

    public static void main(String[] args) {
        TestPrimitiveType test = new TestPrimitiveType();
        test.defaultValue();
    }

    private void defaultValue() {
        System.out.println("布尔型的默认值是：" + c);
        System.out.println("byte的默认值是：" + e);
        System.out.println("字符型的默认值是：" + d);
        System.out.println("短整型的默认值是：" + j);
        System.out.println("整型的默认值是：" + a);
        System.out.println("长整型的默认值是：" + h);
        System.out.println("单精度浮点型的默认值是：" + f);
        System.out.println("双精度浮点型的默认值是：" + b);
    }
}
