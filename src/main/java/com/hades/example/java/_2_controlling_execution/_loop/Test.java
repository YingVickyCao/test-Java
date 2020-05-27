package com.hades.example.java._2_controlling_execution._loop;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        System.out.println("=======testFor========");
        testWhile();

        System.out.println("=======testDoWhile========");
        testDoWhile();
        System.out.println();

        System.out.println("=======testFor========");
        testFor();

        System.out.println("=======testForeach========");
        testForeach();
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


        for (int i = 1, j = i + 10; i < 5; i++, j = i * 2) {
            System.out.print("(" + i + "," + j + "),");
        }
        System.out.println();
    }

    private static void testForeach() {
        int[] ints = new int[3];
        ints[0] = 1;
        ints[1] = 2;
        ints[2] = 3;
        System.out.println(ints.length);

        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + "  ");
        }
        System.out.println();

        for (int x : ints) {
            System.out.print(x + "  ");
        }

        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");

        System.out.println();
        for (int i = 0; i < strings.size(); i++) {
            System.out.print(strings.get(i) + "  ");
        }

        System.out.println();
        for (String s : strings) {
            System.out.print(s + "  ");
        }
    }
}