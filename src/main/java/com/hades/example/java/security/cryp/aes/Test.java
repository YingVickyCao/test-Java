package com.hades.example.java.security.cryp.aes;

import com.hades.example.java.security.Constants;

import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) {
        new Test().test();
    }

    private void test() {
        String toEncryptContent = Constants.toEncryptContent2;
        String password = "abc1234567890";

        AESTool tool = AESTool.getInstance();
        String decrypted = tool.encryptWithBase64(toEncryptContent, password);
        System.out.println(decrypted); // 0paME9s87VlM9341Vuap8g==

        String plaintext = tool.decryptWithBase64(decrypted, password);
        System.out.println(plaintext); // Hi123

        // ---
        String decrypted2 = tool.encryptWithHex(toEncryptContent, password);
        System.out.println(decrypted2); // D2968C13DB3CED594CF77E3556E6A9F2

        String plaintext2 = tool.decryptHexWith(decrypted2, password);
        System.out.println(plaintext2); // Hi123

        // ---
        byte[] decryptedBytes = tool.encrypt(toEncryptContent.getBytes(StandardCharsets.UTF_8), password.getBytes(StandardCharsets.UTF_8));
        String decrypted3 = new String(decryptedBytes);
        System.out.println(decrypted3); // Җ��<�YL�~5V��

        byte[] plaintextBytes = tool.decrypt(decryptedBytes, password.getBytes(StandardCharsets.UTF_8));
        String plaintext3 = new String(plaintextBytes);
        System.out.println(plaintext3); // Hi123
    }
}