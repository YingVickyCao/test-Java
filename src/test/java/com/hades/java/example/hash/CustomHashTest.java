package com.hades.java.example.hash;

import com.hades.java.example.cryptographic.hash.CustomHash;
import org.junit.Assert;
import org.junit.Test;

public class CustomHashTest {
    @Test
    public void example() {
        CustomHash test = new CustomHash();
        Assert.assertEquals("BCD",test.hash("ABC"));
    }
}