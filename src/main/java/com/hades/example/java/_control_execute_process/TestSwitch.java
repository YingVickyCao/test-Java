package com.hades.example.java._control_execute_process;

public class TestSwitch {
    public static void main(String[] args) {
        System.out.println("Int in switch");
        testSwitch4Int();

        System.out.println("Short in switch");
        testSwitch4Short();

        System.out.println("Byte in switch");
        testSwith4Byte();

        System.out.println("Char in switch");
        testSwitch4Char();

        System.out.println("String in switch");
        testSwitch4String();
    }

    private static void testSwitch4Int() {
        int[] ints = new int[5];
        for (int i = 0; i < 5; i++) {
            ints[i] = i + 1;
        }

        for (int i : ints) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                    System.out.println(i + " <3");
                    break;

                case 3:
                    System.out.println(i + " =3");
                    break;

                default:
                    System.out.println(i + " >3");
            }
        }
    }

    private static void testSwitch4Short() {
        short[] ints = new short[5];
        for (short i = 0; i < 5; i++) {
            ints[i] = (short) (i + 1);
        }

        for (short i : ints) {
            switch (i) {
                case (short) 0:
                case (short) 1:
                case (short) 2:
                    System.out.println(i + " <3");
                    break;

                case (short) 3:
                    System.out.println(i + " =3");
                    break;

                default:
                    System.out.println(i + " >3");
            }
        }
    }

    private static void testSwith4Byte() {
        byte[] ints = new byte[5];
        for (byte i = 0; i < 5; i++) {
            ints[i] = (byte) (i + 1);
        }

        for (byte i : ints) {
            switch (i) {
                case (byte) 0:
                case (byte) 1:
                case (byte) 2:
                    System.out.println(i + " <3");
                    break;

                case (byte) 3:
                    System.out.println(i + " =3");
                    break;

                default:
                    System.out.println(i + " >3");
            }
        }
    }

    private static void testSwitch4Char() {
        char[] ints = new char[5];
        for (char i = 0; i < 5; i++) {
            ints[i] = (char) (i + 1);
        }

        for (char i : ints) {
            switch (i) {
                case (char) 0:
                case (char) 1:
                case (char) 2:
                    System.out.println(i + " <3");
                    break;

                case (char) 3:
                    System.out.println(i + " =3");
                    break;

                default:
                    System.out.println(i + " >3");
            }
        }
    }

    private static void testSwitch4String() {
        String[] ints = new String[5];
        for (int i = 0; i < 5; i++) {
            ints[i] = i + 1 + "";
        }

        for (String i : ints) {
            switch (i) {
                case "0":
                case "1":
                case "2":
                    System.out.println(i + " <3");
                    break;

                case "3":
                    System.out.println(i + " =3");
                    break;

                default:
                    System.out.println(i + " >3");
            }
        }
    }
}
