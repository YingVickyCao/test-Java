package com.hades.example.java._15_security.cryp.dec;

import java.util.Arrays;

public class TestDec {
    public static void main(String[] args) {
        TestDec testDec = new TestDec();
        testDec.des();
    }

    private void des() {
        System.out.println("Dec, start");
        DesTool desTool = new DesTool();

        byte[] encrypted = desTool.encrypt(DesTool.TO_ENCRYPT_CONTENT.getBytes()); // "Hi123"
        System.out.println(Arrays.toString(encrypted)); // [121, 53, 22, 92, -126, -93, -79, 94]

        byte[] decrypted = desTool.decrypt(DesTool.TO_DECRYPT_CONTENT);// [121, 53, 22, 92, -126, -93, -79, 94]
        System.out.println(Arrays.toString(decrypted)); // [72, 105, 49, 50, 51]
        System.out.println(new String(decrypted));  // Hi123
        //        System.out.println((char)72); // H

        System.out.println("Dec, end");
    }
}
