package com.example.hades.java._enum;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.testToString();
        test.testValues();
        test.testOrdinal();
        test.testEnumWitchSwitch();
    }

    private void testToString() {
        Nums nums = Nums.ONE;
        System.out.println("testToString: " + nums);
    }

    private void testValues() {
        System.out.print("testValues: ");
        for (Nums s : Nums.values()) {
            System.out.print(s + ",");
        }

        System.out.println();
    }

    private void testOrdinal() {
        System.out.print("testOrdinal: ");
        for (Nums s : Nums.values()) {
            System.out.print(s.ordinal() + ",");
        }

        System.out.println();
    }

    private void testEnumWitchSwitch() {
        System.out.print("testEnumWitchSwitch: ");

        Nums nums = Nums.TWO;
        switch (nums) {
            case ONE:
                System.out.println("is One");
                break;

            case TWO:
                System.out.println("is Two");
                return;

            case THREE:
                System.out.println("is isThree");
                break;
        }
    }
}
