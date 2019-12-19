package com.example.hades.java.code._primitive_type;

import com.example.hades.java.code._framework.Log;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestBigDecimal {
    private static final String TAG = TestBigDecimal.class.getSimpleName();

    public static void main(String[] args) {
        TestBigDecimal test = new TestBigDecimal();
        test.create();
        System.out.println();

        test.calculate();
        System.out.println();

        test.cutOff();
        System.out.println();

        test.newInstance();
        System.out.println();

        test.compare();
    }

    private void create() {
        BigDecimal bigDecimal1 = new BigDecimal(58.555489060456); // not recommended, unpredictable
        BigDecimal bigDecimal2 = new BigDecimal(5); // predictable
//        TestBigDecimal bigDecimal3 = new TestBigDecimal("2.3"); // predictable,priority use
        BigDecimal bigDecimal3 = new BigDecimal(String.valueOf(2.3));

        Log.d(TAG, "create", "bigDecimal1=" + bigDecimal1); // bigDecimal=58.5554890604559972189235850237309932708740234375
        Log.d(TAG, "create", "bigDecimal2=" + bigDecimal2);
        Log.d(TAG, "create", "bigDecimal3=" + bigDecimal3);
    }

    private void calculate() {
        BigDecimal a = new BigDecimal("4.5");
        BigDecimal b = new BigDecimal("1.5");
        BigDecimal b2 = new BigDecimal("1.3");

        Log.d(TAG, "calculate", "a + b =" + a.add(b)); // 6.0
        Log.d(TAG, "calculate", "a - b =" + a.subtract(b)); // 3.0
        Log.d(TAG, "calculate", "a * b =" + a.multiply(b)); // 6.75
        Log.d(TAG, "calculate", "a / b =" + a.divide(b));   // 3
        // 不能整除 ERROR java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
//        Log.d(TAG, "calculate", "a / b2 =" + a.divide(b2));
        // 2 = 小数点后保留位数， ROUND_HALF_UP = 四舍五入
        Log.d(TAG, "calculate", "a / b2 =" + a.divide(b2, 2, BigDecimal.ROUND_HALF_UP));// a / b2 =3.46
    }

    private void cutOff() {
        // 截断和四舍五入可用setScale
        // 减乘除其实最终都返回的是一个新的BigDecimal对象，因为BigInteger与BigDecimal都是不可变的
        BigDecimal decimal = new BigDecimal("4.5635");
        Log.d(TAG, "cutOff", "@" + decimal.hashCode() + "=" + decimal); // @1414689=4.5635

        decimal = decimal.setScale(3, RoundingMode.HALF_UP); //保留3位小数，且四舍五入
        Log.d(TAG, "cutOff", "@" + decimal.hashCode() + "=" + decimal); // @141487=4.564
    }

    private void newInstance() {
        BigDecimal a = new BigDecimal("4.5");
        BigDecimal b = new BigDecimal("1.5");
        a.add(b);
        Log.d(TAG, "newInstance", String.valueOf(a)); //4.5
    }

    private void compare() {
        BigDecimal d = new BigDecimal("100.00");
        BigDecimal d2 = new BigDecimal("100.000");
        Log.d(TAG, "compare", d.compareTo(d2) + ""); // 0
        Log.d(TAG, "compare", d.equals(d2) + ""); // false
    }
}