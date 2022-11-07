package com.hades.java.test.cryptographic.encryption_and_decryption.base64;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Tool {
    public static final String EXAMPLE_TO_ENCODE_STR = "subjects?abcd";
    public static final String EXAMPLE_TO_ENCODE_STR2 = "This is the content of any resource read from somewhere.into a stream. This can be text, image, video or any other stream.";
    public static final String EXAMPLE_TO_ENCODE_STR3 = "!";
    public static final String EXAMPLE_TO_ENCODE_STR4 = "Man";
    public static final byte[] EXAMPLE_TO_ENCODE_BYTES = new byte[]{65, 49, 99};

    public static final String FILE_BASE64 = "base64_file.txt";

    public static final String EXAMPLE_TO_DECODE_STR_4_BASIC = "c3ViamVjdHM/YWJjZA==";
    public static final String EXAMPLE_TO_DECODE_STR_4_URL = "c3ViamVjdHM_YWJjZA==";
    public static final String EXAMPLE_TO_DECODE_STR2_4_MIME = "VGhpcyBpcyB0aGUgY29udGVudCBvZiBhbnkgcmVzb3VyY2UgcmVhZCBmcm9tIHNvbWV3aGVyZS5p\r\n" +
            "bnRvIGEgc3RyZWFtLiBUaGlzIGNhbiBiZSB0ZXh0LCBpbWFnZSwgdmlkZW8gb3IgYW55IG90aGVy\r\n" +
            "IHN0cmVhbS4=";
    public static final String EXAMPLE_TO_DECODE_STR3 = "IQ==";
    public static final String EXAMPLE_TO_DECODE_STR4 = "TWFu";
    public static final byte[] EXAMPLE_TO_DECODE_BYTES = new byte[]{81, 84, 70, 106};

    public String encode(String str) {
        if (null == str || str.isEmpty()) {
            return str;
        }
        return Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }

    public byte[] encode(byte[] src) {
        return Base64.getEncoder().encode(src);
    }

    public ByteBuffer encode(ByteBuffer buffer) {
        return Base64.getEncoder().encode(buffer);
    }

    public String decode(String src) {
        byte[] result = Base64.getDecoder().decode(src);
        return new String(result, StandardCharsets.UTF_8);
    }

    public byte[] decode(byte[] src) {
        return Base64.getDecoder().decode(src);
    }

    public ByteBuffer decode(ByteBuffer buffer) {
        return Base64.getDecoder().decode(buffer);
    }

    public String url_encode(String str) {
        if (null == str || str.isEmpty()) {
            return str;
        }
        return Base64.getUrlEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }

    public String mine_encode(String str) {
        if (null == str || str.isEmpty()) {
            return str;
        }
        return Base64.getMimeEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }

    public void wrapping_write(String str, String fileName) {
        if (null == str || str.isEmpty()) {
            return;
        }
        try {
            /**
             * 写文件
             * 编码器封装OutputStream，输出是Base64编码形式，该过程不不需要缓冲Buffer
             */
            OutputStream out = Base64.getEncoder().wrap(new FileOutputStream(fileName));
            out.write(str.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wrapping_read(String fileName) {
        try {
            /**
             * 读文件
             * 解码器封装InputStream，输出经过Base64解码，该过程不需要缓冲Buffer
             */
            InputStream in = Base64.getDecoder().wrap(new FileInputStream(fileName));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = in.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}