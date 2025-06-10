package com.hades.java.example.cryptographic.base64;

import com.hades.java.example.cryptographic.encryption_and_decryption.base64.CustomCryptographic;
import org.junit.Assert;
import org.junit.Test;

public class CustomCryptographicTest {

    @Test
    public void encode() {
        CustomCryptographic example = new CustomCryptographic();
        String result = example.encode(CustomCryptographic.TO_ENCODE_STR);
        Assert.assertEquals(CustomCryptographic.TO_DECODE_STR, result);
    }

    @Test
    public void decode() {
        CustomCryptographic example = new CustomCryptographic();
        String result = example.decode(CustomCryptographic.TO_DECODE_STR);
        Assert.assertEquals(CustomCryptographic.TO_ENCODE_STR, result);
    }
}