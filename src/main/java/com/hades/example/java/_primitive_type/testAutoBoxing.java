package com.hades.example.java._primitive_type;

public class testAutoBoxing {
    public static void main(String[] args) {
        new testAutoBoxing().test();
    }

    private void test() {
        checkAutoBoxing(null);
        checkAutoBoxing(1);
        checkAutoBoxing(new Integer(2));
        checkAutoBoxing("2");

        checkAutoBoxing2(null);
        checkAutoBoxing2(1);
        checkAutoBoxing2(new Integer(2));
        checkAutoBoxing2("2");
    }

    private void checkAutoBoxing(Object integer) {
        System.out.println("integer @1=" + integer);
        if (null != integer && integer instanceof Integer) {
            int num = ((Integer) integer).intValue();
            System.out.println("integer @2=" + num);
        }
        System.out.println();
    }


    private void checkAutoBoxing2(Object integer) {
        System.out.println("integer @1=" + integer);
        if (integer instanceof Integer) {
            int num = (Integer) integer;
            System.out.println("integer @2=" + num);
        }
        System.out.println();
    }

}