package com.hades.example.java._15_security.read_cert;

import com.hades.example.java._11_string_stringbuffer_stringbuilder.StringTool;
import com.hades.example.java._15_security.hash.base64.Base64Tool;
import com.hades.example.java._15_security.hash.sha.SHATool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;

// https://blog.csdn.net/qq_25933249/article/details/103304964
public class CertificateHelper {
    private IHashPublicKey mHashPublicKey;

    private final String ORIGIN_CERT_HASH = "AEFE2A5934BA2B624DBD50D7424F1A88EF5D0CF0B37F51A8E5D48FFB405DAD57";
    private final String ORIGIN_CERT_HASH_OF_PUBLIC_KEY = "[-126, 35, 89, -43, -26, -75, 83, 99, -41, 31, -46, -96, -114, 1, -125, -85, -107, 27, -22, 121, -36, 59, 97, 49, 125, -117, 125, 109, 110, -18, 120, -89]";

    public CertificateHelper(IHashPublicKey hashPublicKey) {
        this.mHashPublicKey = hashPublicKey;
    }

    public void setHashPublicKey(IHashPublicKey hashPublicKey) {
        mHashPublicKey = hashPublicKey;
    }

    public void parseCertificate(String certName) {
        /**
         * X.509 is a standard format for public key certificates, digital documents that securely associate cryptographic key pairs with identities such as websites, individuals, or organizations.
         */
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(certName);
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            // Read Certificate File
            X509Certificate cert = (X509Certificate) cf.generateCertificate(inputStream);
//            System.out.println(cert.getVersion());  // 3
//            System.out.println(cert.getSerialNumber()); // 110

//            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
//            System.out.println(dateformat.format(cert.getNotBefore())); // 2018/11/07
//            System.out.println(dateformat.format(cert.getNotAfter()));  // 2020/11/06

//            System.out.println(cert.getSubjectDN().getName());  // CN=*.csdn.net, OU=IT, O=北京创新乐知信息技术有限公司, L=北京市, C=CN
//            System.out.println(cert.getIssuerDN().getName());  // CN=Avast trusted CA, OU=Software Development, O=AVAST, ST=Prague, C=CZ
//            System.out.println(cert.getSigAlgName());  // SHA256withRSA

//            checkCertIsModified(cert);

            // Check Certificate is out of date
//            cert.checkValidity();
//            Certificate cert = cf.generateCertificate(inputStream);
            // Get Public Key of Certificate
            PublicKey publicKey = cert.getPublicKey();
            hash(publicKey);

            printPin(cert);
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
    }

    // How to check Certificate is modified ? Use Fingerprints algorithm to hash Certificate Hash Value
    private boolean checkCertIsModified(X509Certificate cert) {
        try {
            byte[] encoded = cert.getEncoded();
            String desc = SHATool.getInstance()
//                    .setAlgorithmName(SHATool.ALGORITHM_NAME_SH1)
                    .setAlgorithmName(SHATool.ALGORITHM_NAME_SHA256)
                    .digest_bytes2String(encoded);

            // AEFE2A5934BA2B624DBD50D7424F1A88EF5D0CF0B37F51A8E5D48FFB405DAD57
            // 6A6FECCB003E292CFFF66D0A70B8B61386C30CC7
            System.out.println(desc);
            // [AE, FE, 2A, 59, 34, BA, 2B, 62, 4D, BD, 50, D7, 42, 4F, 1A, 88, EF, 5D, 0C, F0, B3, 7F, 51, A8, E5, D4, 8F, FB, 40, 5D, AD, 57]
            // [6A, 6F, EC, CB, 00, 3E, 29, 2C, FF, F6, 6D, 0A, 70, B8, B6, 13, 86, C3, 0C, C7]
            StringTool.getInstance().spiltStringByStep(desc, 2);

            boolean isModified = !ORIGIN_CERT_HASH.equalsIgnoreCase(desc);
            System.out.println("isModified:" + isModified);
            return isModified;
        } catch (CertificateEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public byte[] hash(PublicKey publicKey) {
        byte[] publick_key = mHashPublicKey.hash(publicKey.getEncoded());
        // Hash public key
        System.out.println("-----------------公钥--------------------");
        // [-126, 35, 89, -43, -26, -75, 83, 99, -41, 31, -46, -96, -114, 1, -125, -85, -107, 27, -22, 121, -36, 59, 97, 49, 125, -117, 125, 109, 110, -18, 120, -89]
        System.out.println(Arrays.toString(publick_key));
//        boolean isRightPublicKey = Arrays.toString(publick_key).equalsIgnoreCase(ORIGIN_CERT_HASH_OF_PUBLIC_KEY);
//        System.out.println("public key:" + (isRightPublicKey ? "equal" : "not equal"));

        // [22, -105, -115, 22, -81, 28, 113, 35, 31, 63, 10, -39, -105, -62, 25, -90, -16, -64, 126, 38, -72, -66, -65, 123, 37, -99, 96, 66, -117, 16, 116, 16]
        byte[] s = SHATool.getInstance().digest_bytes2bytes(publick_key);// Choose any hash,e.g, Base64, SHA-256
        System.out.println(Arrays.toString(s));
        System.out.println("-----------------公钥--------------------");
        return publick_key;
    }


    private void printPin(X509Certificate cert) {
//        Base64(SHA256(SubjectPublicKeyInfo))
        try {
            byte[] sha256 = SHATool.getInstance().digest_bytes2bytes(cert.getPublicKey().getEncoded());
            System.out.println(sha256);
            String base64 = Base64Tool.getInstance().encode_Bytes2String(sha256);
            System.out.println(base64);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
