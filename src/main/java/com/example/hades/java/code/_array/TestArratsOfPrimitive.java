package com.example.hades.java.code._array;

public class TestArratsOfPrimitive {
    int[] a1 = {1, 2, 3};  // Recommend , 分配存储空间
    int[] a2;

    int a3[];

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

    public static void main(String[] args) {
        TestArratsOfPrimitive test = new TestArratsOfPrimitive();
        test.print();
    }
}
