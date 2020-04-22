package com.hades.example.java.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String mock_to_entry_content = "Hi123";

    public static void main(String[] args) {
        toSHA002("123456123456");
        toSHA003("123456123456");
    }

    public static final String ALGORITHM_SHA_256 = "SHA-256";

    public static String toSHA002(String str) {
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance(ALGORITHM_SHA_256);
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            encodeStr = byte2Hex(messageDigest.digest());
            System.out.println(encodeStr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    private static String byte2Hex(byte[] bytes) {
        StringBuilder stringBuffer = new StringBuilder();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    private static void toSHA003(String text) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM_SHA_256);
            messageDigest.update(text.getBytes());
            byte[] digest = messageDigest.digest();
            int length = digest.length;
            StringBuilder buf = new StringBuilder(length * 2);
            //密文转换成16进制
            for (int j = 0; j < length; j++) {
                buf.append(HEX_DIGITS[(digest[j] >> 4) & 0x0f]);
                buf.append(HEX_DIGITS[digest[j] & 0x0f]);
            }
            System.out.println(buf.toString());

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
