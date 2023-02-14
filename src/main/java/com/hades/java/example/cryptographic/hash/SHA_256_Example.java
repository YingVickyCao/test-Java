package com.hades.java.example.cryptographic.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

// SHA-256
public class SHA_256_Example {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String source = "hello world";

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        // digest 摘要
        byte[] target = md.digest(source.getBytes(StandardCharsets.UTF_8));
        /*
          [-71, 77, 39, -71, -109, 77, 62, 8, -91, 46, 82, -41, -38, 125, -85, -6, -60, -124, -17, -29, 122, 83, -128, -18, -112, -120, -9, -84, -30, -17, -51, -23]
         */
        // 256 （bit，位） / 8 = 32 （byte，字节）
        System.out.println(Arrays.toString(target));

        String result = bytesToHex(target);
        System.out.println(result); // b94d27b9934d3e08a52e52d7da7dabfac484efe37a5380ee9088f7ace2efcde9
    }

    // use a custom byte to hex converter to get the hashed value in hexadecimal
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}