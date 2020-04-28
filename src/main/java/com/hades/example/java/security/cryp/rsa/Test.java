package com.hades.example.java.security.cryp.rsa;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.test();
    }

    public void test() {
        RSATool RSATool = new RSATool();
//        String toEncryptContent = "The new podcast series brings together the latest insights, stories, and discussions from industry experts. Topics range from responsible engagement, to advice from experts on mergers, acquisitions, and venture capital, to privacy and accessibility.";//要加密的字符串
        String toEncryptContent = "Hi123";//要加密的字符串
        System.out.println("明文：");
        System.out.println(toEncryptContent);
        System.out.println();

        String encrypted = RSATool.encrypt(toEncryptContent);
        System.out.println("密文:");
        System.out.println(encrypted);
        System.out.println();

        String decrypted = RSATool.decrypt(encrypted);
        System.out.println("解密后:");
        System.out.println(decrypted);
    }
}