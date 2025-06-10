package com.hades.java.example.cryptographic.hash;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MD5ToolExample {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
//        MD5Tool tool = new MD5Tool();
//        String result = tool.digest("888qtqyhh");
//        System.out.println(result); // 结果可以有大写，也可以有小写。
//
//        char[] chars = result.toCharArray();
//        List<Character> characterList = new ArrayList<>();
//        for (int i = 0; (i+1) < chars.length; i = i + 1) {
//            // value is in  ASCII
//            if (('0' <= chars[i] && chars[i] <= '9') && ('A' <= chars[i + 1] && chars[i + 1] < 'Z')) {
//                characterList.add(chars[i]);
//                characterList.add(chars[i + 1]);
//            }
//        }
//        System.out.println(characterList);


        SecureRandom random = new SecureRandom();
        System.out.println(Arrays.toString(random.generateSeed(10)));;



        byte[] plaintext = new byte[]{1,2};
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        keygen.init(256);
        SecretKey key = keygen.generateKey();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] ciphertext = cipher.doFinal(plaintext);
        byte[] iv = cipher.getIV();
        System.out.println(Arrays.toString(ciphertext));
        System.out.println(Arrays.toString(iv));
    }
}