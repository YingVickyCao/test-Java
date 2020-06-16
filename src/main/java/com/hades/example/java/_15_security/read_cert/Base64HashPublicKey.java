package com.hades.example.java._15_security.read_cert;

import com.hades.example.java._15_security.hash.base64.Base64Tool;

public class Base64HashPublicKey implements IHashPublicKey {
    @Override
    public byte[] hash(byte[] publicKey) {
        return Base64Tool.getInstance().encode_bytes2bytes(publicKey);
    }
}
