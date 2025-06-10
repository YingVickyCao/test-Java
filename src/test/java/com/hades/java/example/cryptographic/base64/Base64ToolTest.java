package com.hades.java.example.cryptographic.base64;

import com.hades.java.example.cryptographic.encryption_and_decryption.base64.Base64Tool;
import org.junit.Assert;
import org.junit.Test;

import java.nio.ByteBuffer;

public class Base64ToolTest {

    @Test
    public void encode_string() {
        Base64Tool tool = new Base64Tool();
        Assert.assertEquals(Base64Tool.EXAMPLE_TO_DECODE_STR_4_BASIC, tool.encode(Base64Tool.EXAMPLE_TO_ENCODE_STR));
        Assert.assertEquals(Base64Tool.EXAMPLE_TO_DECODE_STR3, tool.encode(Base64Tool.EXAMPLE_TO_ENCODE_STR3));
        Assert.assertEquals(Base64Tool.EXAMPLE_TO_DECODE_STR4, tool.encode(Base64Tool.EXAMPLE_TO_ENCODE_STR4));
    }

    @Test
    public void encode_bytes() {
        Base64Tool tool = new Base64Tool();
        byte[] result = tool.encode(Base64Tool.EXAMPLE_TO_ENCODE_BYTES);
        Assert.assertArrayEquals(Base64Tool.EXAMPLE_TO_DECODE_BYTES, result);
    }

    @Test
    public void encode_ByteBuffer() {
        Base64Tool tool = new Base64Tool();
        ByteBuffer result = tool.encode(ByteBuffer.wrap(Base64Tool.EXAMPLE_TO_ENCODE_BYTES));
        Assert.assertEquals(ByteBuffer.wrap(Base64Tool.EXAMPLE_TO_DECODE_BYTES), result);
    }

    @Test
    public void decode_string() {
        Base64Tool tool = new Base64Tool();
        String result = tool.decode(Base64Tool.EXAMPLE_TO_DECODE_STR_4_BASIC);
        Assert.assertEquals(Base64Tool.EXAMPLE_TO_ENCODE_STR, result);
    }

    @Test
    public void decode_bytes() {
        Base64Tool tool = new Base64Tool();
        byte[] result = tool.decode(Base64Tool.EXAMPLE_TO_DECODE_BYTES);
        Assert.assertArrayEquals(Base64Tool.EXAMPLE_TO_ENCODE_BYTES, result);
    }

    @Test
    public void decode_ByteBuffer() {
        Base64Tool tool = new Base64Tool();
        ByteBuffer result = tool.decode(ByteBuffer.wrap(Base64Tool.EXAMPLE_TO_DECODE_BYTES));
        Assert.assertEquals(ByteBuffer.wrap(Base64Tool.EXAMPLE_TO_ENCODE_BYTES), result);
    }

    @Test
    public void url_encode_string() {
        Base64Tool tool = new Base64Tool();
        Assert.assertEquals(Base64Tool.EXAMPLE_TO_DECODE_STR_4_URL, tool.url_encode(Base64Tool.EXAMPLE_TO_ENCODE_STR));
    }


    @Test
    public void mine_encode_string() {
        Base64Tool tool = new Base64Tool();
        Assert.assertEquals(Base64Tool.EXAMPLE_TO_DECODE_STR2_4_MIME, tool.mine_encode(Base64Tool.EXAMPLE_TO_ENCODE_STR2));
        Assert.assertEquals(Base64Tool.EXAMPLE_TO_DECODE_STR_4_BASIC, tool.mine_encode(Base64Tool.EXAMPLE_TO_ENCODE_STR));
    }

    @Test
    public void wrapping_write() {
        Base64Tool tool = new Base64Tool();
        tool.wrapping_write(Base64Tool.EXAMPLE_TO_ENCODE_STR, Base64Tool.FILE_BASE64);
    }

    @Test
    public void wrapping_read() {
        Base64Tool tool = new Base64Tool();
        tool.wrapping_read(Base64Tool.FILE_BASE64);
    }
}