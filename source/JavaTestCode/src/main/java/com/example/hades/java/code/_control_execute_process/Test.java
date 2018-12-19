package com.example.hades.java.code._control_execute_process;

public class Test {
    public static void main(String[] args) {
//        testBreakAndContinue();
        testGoto();
    }

    private static void testBreakAndContinue() {
        for (int i = 0; i < 10; i++) {
            if (i == 7) {
                break;
            }

            if (i % 3 != 0) {
                continue;
            }
            System.out.print(i + "  ");
        }
    }

    private static void testGoto() {
        int i = 0;

        outer:

        for (; true; ) {
            inner:

            for (; i < 10; i++) {
                System.out.println("i=" + i);
                if (i == 2) {
                    System.out.println("continue");
                    continue;
                }

                if (i == 3) {
                    System.out.println("break");
                    i++;
                    break;
                }

                if (i == 7) {
                    System.out.println("continue outer");
                    i++;
                    continue outer; // break all iteration, and jump to label outer, begin iteration again
                }

                if (i == 8) {
                    System.out.println("break outer");
                    break outer; // break all iteration, and jump to label outer, never begin iteration again.
                }

                for (int k = 0; k < 5; k++) {
                    if (k == 3) {
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }
    }
}
