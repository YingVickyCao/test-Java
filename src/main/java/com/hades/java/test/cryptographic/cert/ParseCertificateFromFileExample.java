package com.hades.java.test.cryptographic.cert;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;

public class ParseCertificateFromFileExample {
    public static void main(String[] args) throws FileNotFoundException, CertificateException {
        String cert_example_1 = "Self_cert_20221019_20231019.cer"; // 证书命名规范：开始日期_结束日期
        String cert_example_2 = "csdn_2021103_20221203.cer";

        String path = ClassLoader.getSystemResource(cert_example_1).getPath();

        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        FileInputStream in = new FileInputStream(path);
        X509Certificate cert = (X509Certificate) cf.generateCertificate(in);

        /*
        [
            [
            Version: V3
            Subject: CN=*.csdn.net, O=XXX公司, ST=北京市, C=CN
            Signature Algorithm: SHA256withRSA, OID = 1.2.840.113549.1.1.11
            Key:  Sun RSA public key, 2048 bits
            modulus: 19500398755184393795811559142464147827895590203284196036434447429659716256804833848829503650826407204176293654622481227814421256472566679167131720828893108207125549641898173691006522926968050975385066191728327199567131828239906096405752696187898767175808583416839681952087207642586748699886504686309787073876097866047543185601701916255560871221168594108972261152932862674960394363851145132162523508782998432794675208562296919554797987973852821446590361822415918815137731151207604260917743973580583424448671891341389039211251826228908518294190753493355207269407103112105122674027551747788996590147755654062017082921741
            public exponent: 65537
            Validity: [From: Wed Nov 03 08:00:00 CST 2021,
            To: Sat Dec 03 07:59:59 CST 2022]
            Issuer: CN=GeoTrust CN RSA CA G1, OUs=www.digicert.com, O=DigiCert Inc, C=US
            SerialNumber: [    0fa4bfef 82e81e9c 4e19bff2 e5b9a087]
            Certificate Extensions: 10
            [1]: ObjectId: 1.3.6.1.4.1.11129.2.4.2 Criticality=false
            Extension unknown: DER encoded OCTET string =
            0000: 04 82 01 6F 04 82 01 6B   01 69 00 77 00 29 79 BE  ...o...k.i.w.)y.
            0010: F0 9E 39 39 21 F0 56 73   9F 63 A5 77 E5 BE 57 7D  ..99!.Vs.c.w..W.
            0020: 9C 60 0A F8 F9 4D 5D 26   5C 25 5D C7 84 00 00 01  .`...M]&%].....
            0030: 7C E4 98 19 78 00 00 04   03 00 48 30 46 02 21 00  ....x.....H0F.!.
            0040: BE 2D D8 85 7D 36 48 44   47 F5 AD E5 0F E0 5D 41  .-...6HDG.....]A
            0050: 88 EE C6 46 61 30 63 78   F2 25 ED 26 8A 56 06 BE  ...Fa0cx.%.&.V..
            0060: 02 21 00 C8 5A E7 DB 5D   22 4B 96 75 1D F9 E8 36  .!..Z..]"K.u...6
            0070: 49 4C 39 24 73 9C 20 5A   5B 96 83 65 E3 85 C3 6D  IL9$s. Z[..e...m
            0080: 68 D6 75 00 76 00 51 A3   B0 F5 FD 01 79 9C 56 6D  h.u.v.Q.....y.Vm
            0090: B8 37 78 8F 0C A4 7A CC   1B 27 CB F7 9E 88 42 9A  .7x...z..'....B.
            00A0: 0D FE D4 8B 05 E5 00 00   01 7C E4 98 19 32 00 00  .............2..
            00B0: 04 03 00 47 30 45 02 21   00 C0 21 24 ED 87 52 1C  ...G0E.!..!$..R.
            00C0: C3 7C 50 06 29 ED 8D A8   B2 11 62 63 1B B5 76 C5  ..P.).....bc..v.
            00D0: E9 ED 43 20 0C 8A CA 1C   9F 02 20 77 F5 4D 50 55  ..C ...... w.MPU
            00E0: 09 70 B2 D8 79 2A 2A A5   91 43 B9 93 95 D2 E2 56  .p..y**..C.....V
            00F0: 56 94 09 57 12 51 B8 AA   37 9D 24 00 76 00 41 C8  V..W.Q..7.$.v.A.
            0100: CA B1 DF 22 46 4A 10 C6   A1 3A 09 42 87 5E 4E 31  ..."FJ...:.B.^N1
            0110: 8B 1B 03 EB EB 4B C7 68   F0 90 62 96 06 F6 00 00  .....K.h..b.....
            0120: 01 7C E4 98 19 02 00 00   04 03 00 47 30 45 02 21  ...........G0E.!
            0130: 00 B5 D3 A3 36 F3 59 04   8F 9E B0 7F A4 2C F0 FD  ....6.Y......,..
            0140: BA 21 55 AE 67 43 3C 49   AC A7 E2 B3 28 06 94 E1  .!U.gC<I....(...
            0150: BC 02 20 66 6D B2 D3 C9   48 9A FA A0 DD A1 8A 79  .. fm...H......y
            0160: 6E 88 9E 5E 17 4F 06 BC   1C 7E 88 2F 6F 66 58 4F  n..^.O...../ofXO
            0170: 53 4C C5                                           SL.
            [2]: ObjectId: 1.3.6.1.5.5.7.1.1 Criticality=false
            AuthorityInfoAccess [
            [
            accessMethod: ocsp
            accessLocation: URIName: http://ocsp.dcocsp.cn
            ,
            accessMethod: caIssuers
            accessLocation: URIName: http://crl.digicert-cn.com/GeoTrustCNRSACAG1.crt
            ]
            ]
            [3]: ObjectId: 2.5.29.35 Criticality=false
            AuthorityKeyIdentifier [
            KeyIdentifier [
            0000: 91 9F 5E 31 15 AE 10 9F   AD 60 C1 F7 C1 CC AA 48  ..^1.....`.....H
            0010: 34 2F 0C 26                                        4/.&
            ]
            ]
            [4]: ObjectId: 2.5.29.19 Criticality=true
            BasicConstraints:[
            CA:false
            PathLen: undefined
            ]
            [5]: ObjectId: 2.5.29.31 Criticality=false
            CRLDistributionPoints [
            [DistributionPoint:
            [URIName: http://crl3.digicert.com/GeoTrustCNRSACAG1.crl]
            , DistributionPoint:
            [URIName: http://crl4.digicert.com/GeoTrustCNRSACAG1.crl]
            ]]
            [6]: ObjectId: 2.5.29.32 Criticality=false
            CertificatePolicies [
            [CertificatePolicyId: [2.23.140.1.2.2]
            [PolicyQualifierInfo: [
            qualifierID: 1.3.6.1.5.5.7.2.1
            qualifier: 0000: 16 1B 68 74 74 70 3A 2F   2F 77 77 77 2E 64 69 67  ..http://www.dig
            0010: 69 63 65 72 74 2E 63 6F   6D 2F 43 50 53           icert.com/CPS
            ]]  ]
            ]
            [7]: ObjectId: 2.5.29.37 Criticality=false
            ExtendedKeyUsages [
            serverAuth
            clientAuth
            ]
            [8]: ObjectId: 2.5.29.15 Criticality=true
            KeyUsage [
            DigitalSignature
            Key_Encipherment
            ]
            [9]: ObjectId: 2.5.29.17 Criticality=false
            SubjectAlternativeName [
            DNSName: *.csdn.net
            DNSName: csdn.net
            ]
            [10]: ObjectId: 2.5.29.14 Criticality=false
            SubjectKeyIdentifier [
            KeyIdentifier [
            0000: 99 16 32 AB 04 AB F8 67   B9 12 7D DF 9D A7 8D A7  ..2....g........
            0010: CF FC 2C F2                                        ..,.
            ]
            ]
            ]
            Algorithm: [SHA256withRSA]
            Signature:
            0000: 42 C1 06 C7 6E 91 66 18   86 87 53 7E BE 7D BD BD  B...n.f...S.....
            0010: 1C 63 48 32 FF 87 E8 6B   70 2A A9 FF E9 DF 4D 41  .cH2...kp*....MA
            0020: 8E 68 E7 43 B5 E8 CC C0   52 E9 04 34 B8 D3 D1 7B  .h.C....R..4....
            0030: B1 84 61 09 81 EF 17 74   29 60 74 51 0B EF CA 24  ..a....t)`tQ...$
            0040: FA FE AD EB 44 DD E3 A9   9B B1 2E 3F 2C 28 DB EF  ....D......?,(..
            0050: 7F F7 7C A5 40 E1 09 F1   37 DD 21 8D D6 6A AB 70  ....@...7.!..j.p
            0060: D7 64 AB 57 14 4D 46 E6   D7 B2 F9 E6 F0 D8 05 A0  .d.W.MF.........
            0070: 0F E0 F5 CC B0 66 3E 00   B8 C0 EE 76 29 71 A8 F4  .....f>....v)q..
            0080: 3D BF B7 15 CE 69 AD AD   B8 13 D7 1A FB 7F 73 4D  =....i........sM
            0090: 43 00 27 68 05 38 A1 BD   8C FC 9B 57 BF F3 E9 EC  C.'h.8.....W....
            00A0: 6F 2F BA 1F A0 8D F6 55   CD 8C D6 41 F7 DE E7 78  o/.....U...A...x
            00B0: A3 B4 C1 5E 24 17 BC 8E   51 55 C7 2F A2 3F 01 8E  ...^$...QU./.?..
            00C0: 37 A4 29 2C DB 37 F6 78   31 4D FC FC 46 A4 30 40  7.),.7.x1M..F.0@
            00D0: 65 A3 C5 7A E9 92 20 E2   6C 25 F2 6C 82 A7 EC D6  e..z.. .l%.l....
            00E0: 56 07 1B F0 7B 9A 6B 63   D1 FC 5B 42 20 2E 4A D1  V.....kc..[B .J.
            00F0: 31 1C 99 BA F5 EB 5B 0A   FE 6D 70 AA 47 EF 66 9B  1.....[..mp.G.f.
    ]

         */
        // certification info
        System.out.println(cert.toString());
        /**
         * 证书有效期
         */
        Date effDate = cert.getNotBefore();
        Date expDate = cert.getNotAfter();
        System.out.println(effDate); // Wed Nov 03 08:00:00 CST 2021
        System.out.println(expDate); // Sat Dec 03 07:59:59 CST 2022]
        // version
        System.out.println(cert.getVersion());      // 3
        System.out.println(cert.getSerialNumber()); // 20793849537852254824103520834330140807
        System.out.println(cert.getSubjectDN());    // CN=*.csdn.net, O=北京创新乐知网络技术有限公司, ST=北京市, C=CN
        /**
         * 谁颁布的签名
         */
        System.out.println(cert.getIssuerDN());       // CN=GeoTrust CN RSA CA G1, OU=www.digicert.com, O=DigiCert Inc, C=US
        /**
         * 签名算法
         */
        System.out.println(cert.getSigAlgName());     // SHA256withRSA
        /**
         * 签名值
         */
        /*
            [66, -63, 6, -57, 110, -111, 102, 24, -122, -121, 83, 126, -66, 125, -67, -67, 28, 99, 72, 50, -1, -121, -24, 107, 112, 42, -87, -1, -23, -33, 77, 65, -114, 104, -25, 67, -75, -24, -52, -64, 82, -23, 4, 52, -72, -45, -47, 123, -79, -124, 97, 9, -127, -17, 23, 116, 41, 96, 116, 81, 11, -17, -54, 36, -6, -2, -83, -21, 68, -35, -29, -87, -101, -79, 46, 63, 44, 40, -37, -17, 127, -9, 124, -91, 64, -31, 9, -15, 55, -35, 33, -115, -42, 106, -85, 112, -41, 100, -85, 87, 20, 77, 70, -26, -41, -78, -7, -26, -16, -40, 5, -96, 15, -32, -11, -52, -80, 102, 62, 0, -72, -64, -18, 118, 41, 113, -88, -12, 61, -65, -73, 21, -50, 105, -83, -83, -72, 19, -41, 26, -5, 127, 115, 77, 67, 0, 39, 104, 5, 56, -95, -67, -116, -4, -101, 87, -65, -13, -23, -20, 111, 47, -70, 31, -96, -115, -10, 85, -51, -116, -42, 65, -9, -34, -25, 120, -93, -76, -63, 94, 36, 23, -68, -114, 81, 85, -57, 47, -94, 63, 1, -114, 55, -92, 41, 44, -37, 55, -10, 120, 49, 77, -4, -4, 70, -92, 48, 64, 101, -93, -59, 122, -23, -110, 32, -30, 108, 37, -14, 108, -126, -89, -20, -42, 86, 7, 27, -16, 123, -102, 107, 99, -47, -4, 91, 66, 32, 46, 74, -47, 49, 28, -103, -70, -11, -21, 91, 10, -2, 109, 112, -86, 71, -17, 102, -101]
        */
        byte[] signature = cert.getSignature();
        System.out.println(Arrays.toString(signature));
        System.out.println(cert.getSigAlgOID());    // 1.2.840.113549.1.1.11
        System.out.println(Arrays.toString(cert.getSigAlgParams()));    // null

        PublicKey publicKey = cert.getPublicKey();
        System.out.println(publicKey.getFormat()); // X.509
        /**
         * 公钥算法
         */
        System.out.println(publicKey.getAlgorithm()); // RSA
        /**
         * 公钥
         * 当使用公钥验证证书时，通常会通过"Hash" / "加解密" 处理一下，再使用
         */
        /*
            [48, -126, 1, 34, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -126, 1, 15, 0, 48, -126, 1, 10, 2, -126, 1, 1, 0, -102, 121, 16, -38, -40, -121, 6, -104, 99, -69, 17, 90, -86, 74, -124, 25, 91, 47, 37, -2, -22, -2, -58, -34, 35, -80, -105, -62, 60, -119, -41, 83, 15, 38, 102, 67, 79, -30, -51, 47, 35, 87, 106, -116, -116, -6, -120, 97, 57, 126, -106, -101, 52, 88, 24, 18, 40, 109, 72, 100, -76, 59, 111, 23, 51, -97, 26, -27, -12, 126, 91, -82, 17, -127, 114, -26, 125, -58, -75, -49, -116, 95, -56, -72, -43, -83, 78, -81, 38, 121, -76, 57, -102, 94, 108, 53, 102, 107, 101, 39, -113, -4, -110, -104, -68, -20, 62, 99, -7, -116, 2, -125, -96, 93, 109, 42, -68, -58, -96, 94, 81, -112, 118, 113, -100, -87, -97, 58, -50, -121, 96, -76, 13, 9, -52, -16, -27, 122, -80, 82, 68, -9, 25, -14, -128, 51, 122, -116, -19, 91, -70, -26, -107, -115, 98, 65, -11, -74, 51, 52, 74, -64, -107, -79, -27, -67, 69, 24, -70, 0, 48, 70, -120, 11, 17, -86, -21, 18, 82, -6, 16, 63, -119, -8, 43, -70, -71, -110, 7, 118, 117, 115, 8, -2, -11, 49, 105, -26, 67, -9, 19, -96, -102, -42, -17, -38, 19, -82, 93, -22, 75, 73, 61, -36, 9, -52, 35, 22, -40, 125, -125, 32, 49, 11, -119, -87, 122, 33, 6, 6, -45, 32, -22, 96, -72, 117, -75, 1, 24, -20, 51, 92, -57, -31, -83, 105, -24, -113, 114, 20, -123, 48, -99, 25, -109, 13, 2, 3, 1, 0, 1]
         */
        byte[] encodedKeyOfPublicKey = publicKey.getEncoded();
        System.out.println(Arrays.toString(encodedKeyOfPublicKey));

        BASE64Encoder encoder = new BASE64Encoder();
        String encoded = encoder.encode(encodedKeyOfPublicKey);
        System.out.println("publicKey key value after hashed:" + encoded);
    }
}
