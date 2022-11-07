package com.hades.java.test.cryptographic.base64;

import com.hades.java.test.cryptographic.encryption_and_decryption.base64.Base64Tool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

class Base64ToolTest {

    @Test
    void encode_string() {
        Base64Tool tool = new Base64Tool();
        Assertions.assertEquals(Base64Tool.EXAMPLE_TO_DECODE_STR_4_BASIC, tool.encode(Base64Tool.EXAMPLE_TO_ENCODE_STR));
        Assertions.assertEquals(Base64Tool.EXAMPLE_TO_DECODE_STR3, tool.encode(Base64Tool.EXAMPLE_TO_ENCODE_STR3));
        Assertions.assertEquals(Base64Tool.EXAMPLE_TO_DECODE_STR4, tool.encode(Base64Tool.EXAMPLE_TO_ENCODE_STR4));
    }

    @Test
    void encode_bytes() {
        Base64Tool tool = new Base64Tool();
        byte[] result = tool.encode(Base64Tool.EXAMPLE_TO_ENCODE_BYTES);
        Assertions.assertArrayEquals(Base64Tool.EXAMPLE_TO_DECODE_BYTES, result);
    }

    @Test
    void encode_ByteBuffer() {
        Base64Tool tool = new Base64Tool();
        ByteBuffer result = tool.encode(ByteBuffer.wrap(Base64Tool.EXAMPLE_TO_ENCODE_BYTES));
        Assertions.assertEquals(ByteBuffer.wrap(Base64Tool.EXAMPLE_TO_DECODE_BYTES), result);
    }

    @Test
    void decode_string() {
        Base64Tool tool = new Base64Tool();
        String result = tool.decode(Base64Tool.EXAMPLE_TO_DECODE_STR_4_BASIC);
        Assertions.assertEquals(Base64Tool.EXAMPLE_TO_ENCODE_STR, result);
    }

    @Test
    void decode_bytes() {
        Base64Tool tool = new Base64Tool();
        byte[] result = tool.decode(Base64Tool.EXAMPLE_TO_DECODE_BYTES);
        Assertions.assertArrayEquals(Base64Tool.EXAMPLE_TO_ENCODE_BYTES, result);
    }

    @Test
    void decode_ByteBuffer() {
        Base64Tool tool = new Base64Tool();
        ByteBuffer result = tool.decode(ByteBuffer.wrap(Base64Tool.EXAMPLE_TO_DECODE_BYTES));
        Assertions.assertEquals(ByteBuffer.wrap(Base64Tool.EXAMPLE_TO_ENCODE_BYTES), result);
    }

    @Test
    void url_encode_string() {
        Base64Tool tool = new Base64Tool();
        Assertions.assertEquals(Base64Tool.EXAMPLE_TO_DECODE_STR_4_URL, tool.url_encode(Base64Tool.EXAMPLE_TO_ENCODE_STR));
    }


    @Test
    void mine_encode_string() {
        Base64Tool tool = new Base64Tool();
        Assertions.assertEquals(Base64Tool.EXAMPLE_TO_DECODE_STR2_4_MIME, tool.mine_encode(Base64Tool.EXAMPLE_TO_ENCODE_STR2));
        Assertions.assertEquals(Base64Tool.EXAMPLE_TO_DECODE_STR_4_BASIC, tool.mine_encode(Base64Tool.EXAMPLE_TO_ENCODE_STR));
    }

    @Test
    void wrapping_write() {
        Base64Tool tool = new Base64Tool();
        tool.wrapping_write(Base64Tool.EXAMPLE_TO_ENCODE_STR, Base64Tool.FILE_BASE64);
    }

    @Test
    void wrapping_read() {
        Base64Tool tool = new Base64Tool();
        tool.wrapping_read(Base64Tool.FILE_BASE64);
    }
}