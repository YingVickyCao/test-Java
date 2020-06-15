package com.hades.example.java._15_security.read_cert;

import com.hades.example.java._15_security.hash.sha.SHATool;

public class SHA256HashPublicKey implements IHashPublicKey {
    @Override
    public byte[] hash(byte[] publicKey) {
        return SHATool.getInstance().digest_bytes2bytes(publicKey);
    }
}
