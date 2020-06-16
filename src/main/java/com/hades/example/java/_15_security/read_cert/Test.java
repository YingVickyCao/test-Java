package com.hades.example.java._15_security.read_cert;

public class Test {
    public static void main(String[] args) throws Exception {
        // csdn
        final String certName = "./gitee.cer";
//        final String certName = "./csdn.net.cer";
        CertificateHelper helper = new CertificateHelper(new SHA256HashPublicKey());
        helper.parseCertificate(certName);

//        helper.setHashPublicKey(new Base64HashPublicKey());
//        helper.parseCertificate(certName);
    }
}
