package com.hades.example.java.security;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
//        test.testDec();
        test.custom();
    }

    private void des() {
        System.out.println("Dec, start");
        Des des = new Des();

        byte[] encrypted = des.encrypt(Des.TO_ENCRYPT_CONTENT.getBytes()); // "Hi123"
        System.out.println(Arrays.toString(encrypted)); // [121, 53, 22, 92, -126, -93, -79, 94]

        byte[] decrypted = des.decrypt(Des.TO_DECRYPT_CONTENT);// [121, 53, 22, 92, -126, -93, -79, 94]
        System.out.println(Arrays.toString(decrypted)); // [72, 105, 49, 50, 51]
        System.out.println(new String(decrypted));  // Hi123
        //        System.out.println((char)72); // H

        System.out.println("Dec, end");
    }

    private void custom() {
        CustomCryp customCryp = new CustomCryp();
        String encrypted = customCryp.encrypt(CustomCryp.TO_ENCRYPT_CONTENT);   // "Hi123"
        System.out.println(encrypted);                                          // Ij234

        String decrypted = customCryp.decrypt(CustomCryp.TO_DECRYPT_CONTENT);   // Ij234
        System.out.println(decrypted);                                          // "Hi123"
    }
}
