package com.hades.example.java.security;

public class CustomCryp {
    public final static String TO_ENCRYPT_CONTENT = "Hi123";
    public final static String TO_DECRYPT_CONTENT = "Ij234";

    private final String ALGORITHM_NAME = "DES";
    private final char KEY = 1; // 密钥
    private final int ENCRYPT_MODE = 1;
    private final int DECRYPT_MODE = 2;

    public String encrypt(String toEncryptContent) {
        return crypto(ENCRYPT_MODE,toEncryptContent);
    }

    public String decrypt(String toDecryptContent) {
        return crypto(DECRYPT_MODE,toDecryptContent);
    }

    private String crypto(int mode, String content) {
        if (null == content) {
            return null;
        }
        char[] bytes = content.toCharArray();
        for (int i = 0; i < bytes.length; i++) {
            if (mode == ENCRYPT_MODE) {
                bytes[i] = (char) (bytes[i] + KEY);
            } else if (mode == DECRYPT_MODE) {
                bytes[i] = (char) (bytes[i] - KEY);
            }
        }
        return new String(bytes);
    }
}
