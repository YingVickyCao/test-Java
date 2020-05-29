package com.hades.example.java._2_controlling_execution._control_execute_process;

public class TestBreakContinue {
    public static void main(String[] args) {
        testBreakAndContinue();
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
}
