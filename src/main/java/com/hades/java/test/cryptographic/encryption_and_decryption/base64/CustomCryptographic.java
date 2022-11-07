package com.hades.java.test.cryptographic.encryption_and_decryption.base64;

/**
 * The example is shows how the hash works.
 */
public class CustomCryptographic {
    public static String TO_ENCODE_STR = "ABC";
    public static String TO_DECODE_STR = "BCD";

    public String encode(String str) {
        if (null == str || str.isEmpty()) {
            return str;
        }

        char[] items = str.toCharArray();
        for (int i = 0; i < items.length; i++) {
            items[i] = (char) (items[i] + 1);
        }
        return String.valueOf(items);
    }

    public String decode(String str) {
        if (null == str || str.isEmpty()) {
            return str;
        }

        char[] items = str.toCharArray();
        for (int i = 0; i < items.length; i++) {
            items[i] = (char) (items[i] - 1);
        }
        return String.valueOf(items);
    }
}
