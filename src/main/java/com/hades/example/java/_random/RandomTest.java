package com.hades.example.java._random;

import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {
        generateRandomInnerTen4Double();
        generateRandomInnerTen4Int();
    }

    /**
     * Math.random是0-1的随机数,内部调用 Random random = new Random()
     */
    private static void generateRandomInnerTen4Double() {
        for (int i = 0; i < 10; i++) {
            double v = Math.random() * 10;
            System.out.println(v + "," + Math.ceil(v));
        }
    }

    private static void generateRandomInnerTen4Int() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            // nextInt,nextLong(),nextFloat(),nextDouble()
            int i1 = random.nextInt(9) + 1;
            System.out.println(i1);
        }
    }
}
