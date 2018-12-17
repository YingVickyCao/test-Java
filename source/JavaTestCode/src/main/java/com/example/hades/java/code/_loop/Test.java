package com.example.hades.java.code._loop;

public class Test {

    public static void main(String[] args) {
        System.out.println("=======testFor========");
        testWhile();

        System.out.println("=======testDoWhile========");
        testDoWhile();
        System.out.println();

        System.out.println("=======testFor========");
        testFor();
    }

    private static void testWhile() {
        int i = 0;
        while (i < 5) {
            System.out.print(i + "  ");
            i++;
        }
        System.out.println();

        int j = 5;
        while (j < 5) {
            System.out.print(j + "  ");
            i++;
        }
        System.out.println();
    }

    private static void testDoWhile() {
        int i = 0;
        do {
            System.out.print(i + "  ");
            i++;
        }
        while (i < 5);

        System.out.println();

        int j = 5;
        do {
            System.out.print(j + "  ");
            i++;
        }
        while (j < 5);
    }

    private static void testFor() {
        for (int i = 0; i < 5; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();

        for (int j = 5; j < 5; j++) {
            System.out.print(j + "  ");
        }
    }
}
