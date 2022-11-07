package com.hades.java.test.cryptographic.hash;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class MD5Tool {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public String digest(String str) {
        byte[] bytes = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            messageDigest.reset();
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            // Step 1 : Get bytes
            bytes = messageDigest.digest();
            // Step 2 : Convert 二进制转换到十六进制
//            String result = bytesToHex(bytes);
//            String result = bytesToHex2(bytes);
            String result = bytesToHex3(bytes);
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // TODO：原理
    private String bytesToHex(byte[] bytes) {
        StringBuilder stringBuffer = new StringBuilder();
        for (byte item : bytes) {
            int temp = 0xff & item;
            String hexString = Integer.toHexString(temp);
            if (hexString.length() == 1) {
                stringBuffer.append("0").append(hexString); // 六进制的0f，默认只显示f => 补上0
            } else {
                stringBuffer.append(hexString);
            }
        }
        return stringBuffer.toString().toUpperCase(Locale.US);
    }

    // TODO：原理
    // 通过java提供的BigInteger 二进制转换到十六进制
    private String bytesToHex2(byte[] bytes) {
        BigInteger bigInteger = new BigInteger(1, bytes);
        return bigInteger.toString(16).toUpperCase();
    }

    // TODO：原理
    // 通过位运算，二进制转换到十六进制
    private String bytesToHex3(byte[] bytes) {
        char[] resultArray = new char[bytes.length * 2];
        int index = 0;
        for (byte b : bytes) {
            resultArray[index++] = HEX_DIGITS[b >>> 4 & 0xf];
            resultArray[index++] = HEX_DIGITS[b & 0xf];
        }
        return new String(resultArray).toUpperCase();
    }
}