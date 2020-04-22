package com.hades.example.java.security.md5;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    private final String ALGORITHM_NAME = "MD5";

    public static final String USER_NAME = "ABC";
    public static final String USER_PASSWORD_DECRYPTED = "apple";
    public static final String HASHED_OF_USER_PASSWORD_DECRYPTED = "1F3870BE274F6C49B3E31A0C6728957F";

    // https://md5hashing.net/hash/md5
    public String hash(String content) {
        if (null == content) {
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM_NAME);
            md.update(content.getBytes());
            byte[] digest = md.digest();
            return DatatypeConverter.printHexBinary(digest).toUpperCase();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
