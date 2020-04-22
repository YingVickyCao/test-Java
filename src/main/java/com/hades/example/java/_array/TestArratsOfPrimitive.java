package com.hades.example.java._array;

import java.util.Arrays;

public class TestArratsOfPrimitive {
    int[] a1 = {1, 2, 3};  // Recommend , 分配存储空间
    int[] a2;

    int a3[];

    public static void main(String[] args) {
        TestArratsOfPrimitive test = new TestArratsOfPrimitive();
//        test.print();
        test.testToString();
    }

    private void print(int[] ints) {
        if (null == ints) {
            return;
        }
        for (int i : ints) {
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

        a3 = new int[3]; // 分配存储空间
        System.out.print("a3: ");
        print(a3);
        System.out.println();
    }


    public void testToString(){
        int[] array1 = new int[]{1,2};
        char[] array2 = new char[]{'a','b'};
        // array toString() = 数组存储元素的类型以及数组在内存的位置的一个标识。
        System.out.println(array1.toString()); // [I@c2e1f26
        System.out.println(array2.toString());  // [C@dcf3e99

        System.out.println(Arrays.toString(array1));    // [1, 2]
        System.out.println(Arrays.toString(array2));    // [a, b]

    }
}
