package com.hades.example.java._15_security.hash.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Tool {
    private static volatile Base64Tool mInstance;

    public static Base64Tool getInstance() {
        if (null == mInstance) {
            synchronized (Base64Tool.class) {
                if (null == mInstance) {
                    mInstance = new Base64Tool();
                }
            }
        }
        return mInstance;
    }

    private Base64Tool() {
    }

    public byte[] encode(byte[] src) {
        final Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encode(src);
    }

    public String encodeToString(String src) {
        final Base64.Encoder encoder = Base64.getEncoder();
        final byte[] textByte = src.getBytes(StandardCharsets.UTF_8);
        return encoder.encodeToString(textByte);
    }

    public String encodeToString2(byte[] src) {
        final Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(src);
    }
    public String decodeToString(String src) {
        try {
            final Base64.Decoder decoder = Base64.getDecoder();
            return new String(decoder.decode(src), StandardCharsets.UTF_8);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String decodeToString2(byte[] src) {
        try {
            final Base64.Decoder decoder = Base64.getDecoder();
            return new String(decoder.decode(src), StandardCharsets.UTF_8);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public byte[] decode(String src) {
        try {
            final Base64.Decoder decoder = Base64.getDecoder();
            // ERROR:java.lang.IllegalArgumentException: Last unit does not have enough valid bits
            return decoder.decode(src);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public byte[] decode(byte[] encodedText) {
        try {
            final Base64.Decoder decoder = Base64.getDecoder();
            return decoder.decode(encodedText);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
