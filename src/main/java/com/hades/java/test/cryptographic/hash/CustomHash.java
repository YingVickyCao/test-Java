package com.hades.java.test.cryptographic.hash;

/**
 * The example is shows how the hash works.
 */
public class CustomHash {
    public String hash(String str) {
        if (null == str || str.isEmpty()) {
            return str;
        }

        char[] items = str.toCharArray();
        for (int i = 0; i < items.length; i++) {
            items[i] = (char) (items[i] + 1);
        }
        return String.valueOf(items);
    }
}
