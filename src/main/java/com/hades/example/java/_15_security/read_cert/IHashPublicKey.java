package com.hades.example.java._15_security.read_cert;

public interface IHashPublicKey {
    byte[] hash(byte[] publicKey);
}