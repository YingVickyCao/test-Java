package com.example.hades.java.code._object._initial_value._4_array;

public class TestArratsClassObj {
    Integer[] a1 = {new Integer(1), new Integer(2), 3,}; // Recommend,分配存储空间

    Integer[] a2 = new Integer[]{new Integer(1), new Integer(2), 3,}; // Recommend,分配存储空间

    Integer[] a3 = new Integer[3];// 分配存储空间

    private void print(Integer[] ints) {
        if (null == ints) {
            System.out.print("null");
            return;
        }
        for (Integer i : ints) {
            System.out.print(i + "  ");
        }
    }

    private void print() {
        System.out.print("a1: ");
        print(a1);

        System.out.println();
        System.out.println();

        a2 = a1;
        for (int i = 0; i < a2.length; i++) {
            a2[i] = a2[i] + 1;
        }

        System.out.print("a1: ");
        print(a1);
        System.out.println();

        System.out.print("a2: ");
        print(a2);
        System.out.println();

        System.out.println();

        System.out.print("a3: ");
        print(a3);
        System.out.println();
    }

    public static void main(String[] args) {
        TestArratsClassObj test = new TestArratsClassObj();
        test.print();
    }
}
