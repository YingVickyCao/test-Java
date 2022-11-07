package com.hades.java.test.hash;

import com.hades.java.test.cryptographic.hash.CustomHash;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomHashTest {
    @Test
    public void example() {
        CustomHash test = new CustomHash();
        Assertions.assertEquals("BCD",test.hash("ABC"));
    }
}