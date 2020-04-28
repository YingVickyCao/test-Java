package com.hades.example.java.security.cryp.rsa;

import com.hades.example.java.security.hash.base64.Base64Util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

public class RSATool {

    private static String ALGORITHM_NAME = "RSA";
    private static int KEY_SIZE = 1024;

    private static String PUBLIC_KEY_FILE_NAME = "PublicKey";
    private static String PRIVATE_KEY_FILE_NAME = "PrivateKey";

    private static int ENCRYPT_DATA_MAX_BYTES_SIZE = 117;
    private static int DECRYPT_DATA_MAX_BYTES_SIZE = 128;

    private static final String MOCK_ENCODED_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1+lS/KWOgYHufHjBF0RaJ3qsA59Wz7w32tmbqWVU5I4Ha0UWWKCl3zlnpaApqFDDh9siOGF9AlJDnb1ITGEfW775ChjE4Hhy1/yELjIQNt2G1KJOyrSYUK6uVw9jTW69Jv2CqMmFLKoEVkGpA2w5NeqP9FDXqLNdhxB1u6PTXGQIDAQAB";
    private static final String MOCK_ENCODED_PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALX6VL8pY6Bge58eMEXRFoneqwDn1bPvDfa2ZupZVTkjgdrRRZYoKXfOWeloCmoUMOH2yI4YX0CUkOdvUhMYR9bvvkKGMTgeHLX/IQuMhA23YbUok7KtJhQrq5XD2NNbr0m/YKoyYUsqgRWQakDbDk16o/0UNeos12HEHW7o9NcZAgMBAAECgYB6QCjMn0aBiC+kToiJbpSgnEju+9AR6AfOdO0ghFD/aL4kvS/tVx+8j5DRf4Z3iwbn1n0XEIJ1BRlvkNZnY4lmVfxGwemP5hemXHQq3ZTex5CcHVXUfVcoo4jN+FSXTrEzMZb3GDvRgSTYCQ4iRS4K+HGsp6mnLUweR6/E9XYcTQJBAOTPWcJSKrmsyB2ZUHnI6Ktl+dD04wdv6b2uDk4P3lGd5r1cBw0EDe+jQ8u8U8l9VfxJnNXT15bdj3HMu7UCcCsCQQDLmkvluloAexc0cA1CJRoxt8i6UuEMqU9LzD9SvixVrCG4/dARiXGCZVVw1+NiraY+PkAF3/i3h8DAPAIDSi/LAkAhHloxpE8G3RmCH0Tku83hsTr9odSSqQI+MEllxyo4yhAx7HYgzituOkV/4dyG15twjv8ifC1CawNuR2IMCzRNAkApu2mdH9I80P4ToHgHO8WftTTug/he+QEo3yeHlTVPJiYPXe7c+VgLyyt1IrsXydIOZgIHcj3vmGK4xFQBSp57AkEAogYC/uWVNYX2Vj8czTV6uW08p5Ou6lOaGkGJmq+HNqwHHk0M/9ChkEzJyVnRNkMwIfdKptk5AFtTVQ9DJxaCgw==";

    /**
     * 生成密钥对
     */
    private Key generateKeyPair() throws Exception {
        /** RSA算法要求有一个可信任的随机数源 */
        SecureRandom sr = new SecureRandom();
        /** 为RSA算法创建一个KeyPairGenerator对象 */
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(ALGORITHM_NAME);
        /** 利用上面的随机数据源初始化这个KeyPairGenerator对象 */
        kpg.initialize(KEY_SIZE, sr);
        /** 生成密匙对 */
        KeyPair kp = kpg.generateKeyPair();

        /** 得到公钥 */
        Key publicKey = kp.getPublic();
        System.out.println("公钥1");
        String stringPublicKey = DatatypeConverter.printHexBinary(publicKey.getEncoded());
        // 30819F300D06092A864886F70D010101050003818D0030818902818100B5FA54BF2963A0607B9F1E3045D11689DEAB00E7D5B3EF0DF6B666EA5955392381DAD14596282977CE59E9680A6A1430E1F6C88E185F409490E76F52131847D6EFBE428631381E1CB5FF210B8C840DB761B52893B2AD26142BAB95C3D8D35BAF49BF60AA32614B2A8115906A40DB0E4D7AA3FD1435EA2CD761C41D6EE8F4D7190203010001
        System.out.println(stringPublicKey);
        System.out.println();

        System.out.println("公钥2");
        String stringPublicKey2 = Base64Util.getInstance().encodeToString2(publicKey.getEncoded());
        // MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1+lS/KWOgYHufHjBF0RaJ3qsA59Wz7w32tmbqWVU5I4Ha0UWWKCl3zlnpaApqFDDh9siOGF9AlJDnb1ITGEfW775ChjE4Hhy1/yELjIQNt2G1KJOyrSYUK6uVw9jTW69Jv2CqMmFLKoEVkGpA2w5NeqP9FDXqLNdhxB1u6PTXGQIDAQAB
        System.out.println(stringPublicKey2);
        System.out.println();

        System.out.println("公钥3");
        PublicKey publicKey2 = getPublicKey(stringPublicKey2);
        String stringPublicKey3 = DatatypeConverter.printHexBinary(publicKey2.getEncoded());
        // 30819F300D06092A864886F70D010101050003818D0030818902818100B5FA54BF2963A0607B9F1E3045D11689DEAB00E7D5B3EF0DF6B666EA5955392381DAD14596282977CE59E9680A6A1430E1F6C88E185F409490E76F52131847D6EFBE428631381E1CB5FF210B8C840DB761B52893B2AD26142BAB95C3D8D35BAF49BF60AA32614B2A8115906A40DB0E4D7AA3FD1435EA2CD761C41D6EE8F4D7190203010001
        System.out.println(stringPublicKey3);
        System.out.println();

        /** 得到私钥 */
        Key privateKey = kp.getPrivate();
        System.out.println("私钥1:");
        String stringPrivateKey = DatatypeConverter.printHexBinary(privateKey.getEncoded());
        // 30820276020100300D06092A864886F70D0101010500048202603082025C02010002818100B5FA54BF2963A0607B9F1E3045D11689DEAB00E7D5B3EF0DF6B666EA5955392381DAD14596282977CE59E9680A6A1430E1F6C88E185F409490E76F52131847D6EFBE428631381E1CB5FF210B8C840DB761B52893B2AD26142BAB95C3D8D35BAF49BF60AA32614B2A8115906A40DB0E4D7AA3FD1435EA2CD761C41D6EE8F4D71902030100010281807A4028CC9F4681882FA44E88896E94A09C48EEFBD011E807CE74ED208450FF68BE24BD2FED571FBC8F90D17F86778B06E7D67D1710827505196F90D66763896655FC46C1E98FE617A65C742ADD94DEC7909C1D55D47D5728A388CDF854974EB1333196F7183BD18124D8090E22452E0AF871ACA7A9A72D4C1E47AFC4F5761C4D024100E4CF59C2522AB9ACC81D995079C8E8AB65F9D0F4E3076FE9BDAE0E4E0FDE519DE6BD5C070D040DEFA343CBBC53C97D55FC499CD5D3D796DD8F71CCBBB502702B024100CB9A4BE5BA5A007B1734700D42251A31B7C8BA52E10CA94F4BCC3F52BE2C55AC21B8FDD011897182655570D7E362ADA63E3E4005DFF8B787C0C03C02034A2FCB0240211E5A31A44F06DD19821F44E4BBCDE1B13AFDA1D492A9023E304965C72A38CA1031EC7620CE2B6E3A457FE1DC86D79B708EFF227C2D426B036E47620C0B344D024029BB699D1FD23CD0FE13A078073BC59FB534EE83F85EF90128DF278795354F26260F5DEEDCF9580BCB2B7522BB17C9D20E660207723DEF9862B8C454014A9E7B024100A20602FEE5953585F6563F1CCD357AB96D3CA793AEEA539A1A41899AAF8736AC071E4D0CFFD0A1904CC9C959D136433021F74AA6D939005B53550F4327168283
        System.out.println(stringPrivateKey);
        System.out.println();

        System.out.println("私钥2:");
        String stringPrivateKey2 = Base64Util.getInstance().encodeToString2(privateKey.getEncoded());
        // MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALX6VL8pY6Bge58eMEXRFoneqwDn1bPvDfa2ZupZVTkjgdrRRZYoKXfOWeloCmoUMOH2yI4YX0CUkOdvUhMYR9bvvkKGMTgeHLX/IQuMhA23YbUok7KtJhQrq5XD2NNbr0m/YKoyYUsqgRWQakDbDk16o/0UNeos12HEHW7o9NcZAgMBAAECgYB6QCjMn0aBiC+kToiJbpSgnEju+9AR6AfOdO0ghFD/aL4kvS/tVx+8j5DRf4Z3iwbn1n0XEIJ1BRlvkNZnY4lmVfxGwemP5hemXHQq3ZTex5CcHVXUfVcoo4jN+FSXTrEzMZb3GDvRgSTYCQ4iRS4K+HGsp6mnLUweR6/E9XYcTQJBAOTPWcJSKrmsyB2ZUHnI6Ktl+dD04wdv6b2uDk4P3lGd5r1cBw0EDe+jQ8u8U8l9VfxJnNXT15bdj3HMu7UCcCsCQQDLmkvluloAexc0cA1CJRoxt8i6UuEMqU9LzD9SvixVrCG4/dARiXGCZVVw1+NiraY+PkAF3/i3h8DAPAIDSi/LAkAhHloxpE8G3RmCH0Tku83hsTr9odSSqQI+MEllxyo4yhAx7HYgzituOkV/4dyG15twjv8ifC1CawNuR2IMCzRNAkApu2mdH9I80P4ToHgHO8WftTTug/he+QEo3yeHlTVPJiYPXe7c+VgLyyt1IrsXydIOZgIHcj3vmGK4xFQBSp57AkEAogYC/uWVNYX2Vj8czTV6uW08p5Ou6lOaGkGJmq+HNqwHHk0M/9ChkEzJyVnRNkMwIfdKptk5AFtTVQ9DJxaCgw==
        System.out.println(stringPrivateKey2);
        System.out.println();

        System.out.println("私钥3:");
        PrivateKey privateKey2 = getPrivateKey(stringPrivateKey2);
        String stringPrivateKey3 = DatatypeConverter.printHexBinary(privateKey2.getEncoded());
        // 30820276020100300D06092A864886F70D0101010500048202603082025C02010002818100B5FA54BF2963A0607B9F1E3045D11689DEAB00E7D5B3EF0DF6B666EA5955392381DAD14596282977CE59E9680A6A1430E1F6C88E185F409490E76F52131847D6EFBE428631381E1CB5FF210B8C840DB761B52893B2AD26142BAB95C3D8D35BAF49BF60AA32614B2A8115906A40DB0E4D7AA3FD1435EA2CD761C41D6EE8F4D71902030100010281807A4028CC9F4681882FA44E88896E94A09C48EEFBD011E807CE74ED208450FF68BE24BD2FED571FBC8F90D17F86778B06E7D67D1710827505196F90D66763896655FC46C1E98FE617A65C742ADD94DEC7909C1D55D47D5728A388CDF854974EB1333196F7183BD18124D8090E22452E0AF871ACA7A9A72D4C1E47AFC4F5761C4D024100E4CF59C2522AB9ACC81D995079C8E8AB65F9D0F4E3076FE9BDAE0E4E0FDE519DE6BD5C070D040DEFA343CBBC53C97D55FC499CD5D3D796DD8F71CCBBB502702B024100CB9A4BE5BA5A007B1734700D42251A31B7C8BA52E10CA94F4BCC3F52BE2C55AC21B8FDD011897182655570D7E362ADA63E3E4005DFF8B787C0C03C02034A2FCB0240211E5A31A44F06DD19821F44E4BBCDE1B13AFDA1D492A9023E304965C72A38CA1031EC7620CE2B6E3A457FE1DC86D79B708EFF227C2D426B036E47620C0B344D024029BB699D1FD23CD0FE13A078073BC59FB534EE83F85EF90128DF278795354F26260F5DEEDCF9580BCB2B7522BB17C9D20E660207723DEF9862B8C454014A9E7B024100A20602FEE5953585F6563F1CCD357AB96D3CA793AEEA539A1A41899AAF8736AC071E4D0CFFD0A1904CC9C959D136433021F74AA6D939005B53550F4327168283
        System.out.println(stringPrivateKey3);
        System.out.println();

        /** 用对象流将生成的密钥写入文件 */
        saveKey(publicKey, PUBLIC_KEY_FILE_NAME);
        saveKey(privateKey, PRIVATE_KEY_FILE_NAME);

        return publicKey;
    }

    private void saveKey(Key key, String fileName) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(key);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将文件中的公钥对象读出
     */
    private Key getSavedKey(String keyFileName) {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(keyFileName));
            return (Key) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != ois) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 获取公钥对象
     *
     * @param publicKeyBase64
     * @return
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     */
    private PublicKey getPublicKey(String publicKeyBase64) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_NAME);
            byte[] result  = Base64Util.getInstance().decode(publicKeyBase64);
            X509EncodedKeySpec publicpkcs8KeySpec = new X509EncodedKeySpec(result);
            return keyFactory.generatePublic(publicpkcs8KeySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private PrivateKey getPrivateKey(String privateKeyBase64) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_NAME);
            byte[] result  = Base64Util.getInstance().decode(privateKeyBase64);
            return keyFactory.generatePrivate(new PKCS8EncodedKeySpec(result));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String encrypt(String toEncryptContent) {
        try {
            /** 将文件中的公钥对象读出 */
//            Key publicKey = getSavedKey(PUBLIC_KEY_FILE_NAME);
            Key publicKey = getPublicKey(MOCK_ENCODED_PUBLIC_KEY);
            if (null == publicKey) {
                publicKey = generateKeyPair();
            }
            System.out.println("公钥");
            System.out.println(DatatypeConverter.printHexBinary(publicKey.getEncoded()));

            /** 得到Cipher对象来实现对源数据的RSA加密 */
            Cipher cipher = Cipher.getInstance(ALGORITHM_NAME);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] inputs = toEncryptContent.getBytes();
            /** 执行加密操作 */
            // ERROR:javax.crypto.IllegalBlockSizeException: Data must not be longer than 117 bytes
//            byte[] encrypted = cipher.doFinal(inputs);
            byte[] encrypted = segmentCipherDoFinal(cipher, inputs, ENCRYPT_DATA_MAX_BYTES_SIZE);
            return Base64Util.getInstance().encodeToString2(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String decrypt(String toDecryptContent) {
        try { /** 将文件中的私钥对象读出 */
//            Key privateKey = getSavedKey(PRIVATE_KEY_FILE_NAME);
            Key privateKey = getPrivateKey(MOCK_ENCODED_PRIVATE_KEY);
            if (null == privateKey) {
                return null;
            }
            System.out.println("私钥");
            System.out.println(DatatypeConverter.printHexBinary(privateKey.getEncoded()));

            /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
            Cipher cipher = Cipher.getInstance(ALGORITHM_NAME);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] inputs = Base64Util.getInstance().decode(toDecryptContent);;
            /** 执行解密操作 */
            // ERROR:javax.crypto.IllegalBlockSizeException: Data must not be longer than 128 bytes
//            byte[] decrypted = cipher.doFinal(inputs);
            byte[] decrypted = segmentCipherDoFinal(cipher, inputs, DECRYPT_DATA_MAX_BYTES_SIZE);
            return new String(decrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private byte[] segmentCipherDoFinal(Cipher cipher, byte[] inputArray, int dataMaxBytesSize) {
        byte[] resultBytes = {};
        try {
            int inputLength = inputArray.length;
            // 标识
            int offSet = 0;
            byte[] cache = {};
            while (inputLength - offSet > 0) {
                if (inputLength - offSet > dataMaxBytesSize) {
                    cache = cipher.doFinal(inputArray, offSet, dataMaxBytesSize);
                    offSet += dataMaxBytesSize;
                } else {
                    cache = cipher.doFinal(inputArray, offSet, inputLength - offSet);
                    offSet = inputLength;
                }
                resultBytes = Arrays.copyOf(resultBytes, resultBytes.length + cache.length);
                System.arraycopy(cache, 0, resultBytes, resultBytes.length - cache.length, cache.length);
            }
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultBytes;
    }
}