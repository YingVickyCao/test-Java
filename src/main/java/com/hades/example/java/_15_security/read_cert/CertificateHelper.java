package com.hades.example.java._15_security.read_cert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;

// https://blog.csdn.net/qq_25933249/article/details/103304964
public class CertificateHelper {
    private IHashPublicKey mHashPublicKey;

    public CertificateHelper(IHashPublicKey hashPublicKey) {
        this.mHashPublicKey = hashPublicKey;
    }

    public void setHashPublicKey(IHashPublicKey hashPublicKey) {
        mHashPublicKey = hashPublicKey;
    }

    public byte[] parseCertificate(String certName) {
        /**
         * X.509 is a standard format for public key certificates, digital documents that securely associate cryptographic key pairs with identities such as websites, individuals, or organizations.
         */
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(certName);
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            // Read Certificate File
//            X509Certificate cert = (X509Certificate) cf.generateCertificate(inputStream);
            Certificate cert = cf.generateCertificate(inputStream);
            // Get Public Key of Certificate
            PublicKey publicKey = cert.getPublicKey();
            return hash(publicKey);
        } catch (CertificateException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public byte[] hash(PublicKey publicKey) {
        byte[] desc = mHashPublicKey.hash(publicKey.getEncoded());
        // Hash public key
        System.out.println(Arrays.toString(publicKey.getEncoded()));
        System.out.println("-----------------公钥--------------------");
        System.out.println(Arrays.toString(desc));
        System.out.println("-----------------公钥--------------------");
        return desc;
    }
}
