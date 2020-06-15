package com.hades.example.java._15_security.hash.sha;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHATool {
    private String ALGORITHM_NAME = "SHA-256";
    private static volatile SHATool mInstance;

    public static SHATool getInstance() {
        if (null == mInstance) {
            synchronized (SHATool.class) {
                if (null == mInstance) {
                    mInstance = new SHATool();
                }
            }
        }
        return mInstance;
    }

    private SHATool() {
    }

    public byte[] digest_string2bytes(String originalString) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance(ALGORITHM_NAME);
            return digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] digest_bytes2bytes(byte[] src) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance(ALGORITHM_NAME);
            return digest.digest(src);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String digest_string2string(String originalString) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance(ALGORITHM_NAME);
            byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
