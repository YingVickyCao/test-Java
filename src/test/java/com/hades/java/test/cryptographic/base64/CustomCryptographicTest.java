package com.hades.java.test.cryptographic.base64;

import com.hades.java.test.cryptographic.encryption_and_decryption.base64.CustomCryptographic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomCryptographicTest {

    @Test
    void encode() {
        CustomCryptographic example = new CustomCryptographic();
        String result = example.encode(CustomCryptographic.TO_ENCODE_STR);
        Assertions.assertEquals(CustomCryptographic.TO_DECODE_STR, result);
    }

    @Test
    void decode() {
        CustomCryptographic example = new CustomCryptographic();
        String result = example.decode(CustomCryptographic.TO_DECODE_STR);
        Assertions.assertEquals(CustomCryptographic.TO_ENCODE_STR, result);
    }
}