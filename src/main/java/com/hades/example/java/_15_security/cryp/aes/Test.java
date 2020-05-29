package com.hades.example.java._15_security.cryp.aes;

import com.hades.example.java._15_security.Constants;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.test();
//        test.key();
//        test.key2();
//        test.key3();
    }

    private void test() {
        String toEncryptContent = Constants.toEncryptContent2;
        String key = "abc1234567890";

        AESTool tool = AESTool.getInstance();
        String decrypted = tool.encryptWithBase64(toEncryptContent, key);
        System.out.println(decrypted); // 0paME9s87VlM9341Vuap8g==

        String plaintext = tool.decryptWithBase64(decrypted, key);
        System.out.println(plaintext); // Hi123

        // ---
        String decrypted2 = tool.encryptWithHex(toEncryptContent, key);
        System.out.println(decrypted2); // D2968C13DB3CED594CF77E3556E6A9F2

        String plaintext2 = tool.decryptHexWith(decrypted2, key);
        System.out.println(plaintext2); // Hi123

        // ---
        byte[] decryptedBytes = tool.encrypt(toEncryptContent.getBytes(StandardCharsets.UTF_8), key.getBytes(StandardCharsets.UTF_8));
        String decrypted3 = new String(decryptedBytes);
        System.out.println(decrypted3); // Җ��<�YL�~5V��

        byte[] plaintextBytes = tool.decrypt(decryptedBytes, key.getBytes(StandardCharsets.UTF_8));
        String plaintext3 = new String(plaintextBytes);
        System.out.println(plaintext3); // Hi123
    }

    private void key(){
        AESTool tool = AESTool.getInstance();
        String seed = "seed";
        // 有Seed，每次生成的密钥不同
        SecretKey secretKey = tool.generateKey(seed.getBytes(StandardCharsets.UTF_8));
        if (null != secretKey){
            // 0240F6C02260F0C5DEF90F3EAC7E45A1
            // AAA23BFD997E741463080A35E685F905
            System.out.println(DatatypeConverter.printHexBinary(secretKey.getEncoded()));
        }
    }

    private void key2(){
        AESTool tool = AESTool.getInstance();
        SecretKey secretKey = tool.generateKey();
        if (null != secretKey){
            // 没有Seed，每次生成的密钥不同
            // FE6C6EFCE3E0509B7A03B4A923AFCFA5
            // 26C72F7BF5B3E3F2AFDFA84FEA21C6E5
            System.out.println(DatatypeConverter.printHexBinary(secretKey.getEncoded()));
        }
    }

    private void key3(){
        AESTool tool = AESTool.getInstance();
        SecretKey secretKey = tool.generateKey();
        tool.saveKey(secretKey, AESTool.KEY_FILE_NAME);
        // 09FE15CCD7A564C0D7AD903BFA84B72F
        // 48DBC00BC5F8F41ACAC11341AA6FC4C0
        System.out.println(DatatypeConverter.printHexBinary(secretKey.getEncoded()));

        SecretKey secretKey2 = tool.readKey(AESTool.KEY_FILE_NAME);
        // 09FE15CCD7A564C0D7AD903BFA84B72F
        // 48DBC00BC5F8F41ACAC11341AA6FC4C0
        System.out.println(DatatypeConverter.printHexBinary(secretKey2.getEncoded()));

        String toEncryptContent = Constants.toEncryptContent2;
        byte[] key = secretKey2.getEncoded();

        String decrypted = tool.encryptWithBase64(toEncryptContent, key);
        // y9rktBbnzaxhTT8JxBKEzA==
        // 3s8lLvbZVyd6GT/WBsb/4g==
        System.out.println(decrypted);

        String plaintext = tool.decryptWithBase64(decrypted, key);
        System.out.println(plaintext); // Hi123
    }
}