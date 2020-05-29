package com.hades.example.java._15_security.hash.md5;

import javax.xml.bind.DatatypeConverter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

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
            // 获得一个指定编码的信息摘要算法
            MessageDigest md = MessageDigest.getInstance(ALGORITHM_NAME);
            md.update(content.getBytes());
            byte[] digest = md.digest(); // 获得数据的数据指纹，即信息摘要
            // 十进制：31
            System.out.println(Arrays.toString(digest)); // [31, 56, 112, -66, 39, 79, 108, 73, -77, -29, 26, 12, 103, 40, -107, 127]
            // 十六进制：1F
            return DatatypeConverter.printHexBinary(digest).toUpperCase(); // 1F3870BE274F6C49B3E31A0C6728957F
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // Java   https://www.baeldung.com/java-md5
    // Apache  https://www.baeldung.com/java-md5
    // Guava    https://www.baeldung.com/java-md5
    public String generateChecksum(String filename) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM_NAME);
            md.update(Files.readAllBytes(Paths.get(filename)));
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
