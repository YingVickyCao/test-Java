package com.hades.example.java.security.cryp.custom;

public class TestCustomCryp {
    public static void main(String[] args) {
        TestCustomCryp test = new TestCustomCryp();
        test.custom();
    }

    private void custom() {
        CustomCryp customCryp = new CustomCryp();
        String encrypted = customCryp.encrypt(CustomCryp.TO_ENCRYPT_CONTENT);   // "Hi123"
        System.out.println(encrypted);                                          // Ij234

        String decrypted = customCryp.decrypt(CustomCryp.TO_DECRYPT_CONTENT);   // Ij234
        System.out.println(decrypted);                                          // "Hi123"
    }
}
