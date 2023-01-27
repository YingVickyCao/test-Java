package com.hades.java.test;

import org.junit.Assert;
import org.junit.Test;

public class QATest {
    @Test
    public void test() {
        Assert.assertEquals(0, 18L*24*60*60*1000);
    }
}