package com.hades.example.java.security.cryp.sda256;

import javax.crypto.Cipher;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.util.Base64;

public class SHA256 {

    private static String ALGORITHM_NAME = "RSA";
    private static int KEY_SIZE = 1024;
    private static String PUBLIC_KEY_FILE_NAME = "PublicKey";
    private static String PRIVATE_KEY_FILE_NAME = "PrivateKey";

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
        System.out.println("公钥");
        System.out.println(DatatypeConverter.printHexBinary(publicKey.getEncoded()));

        /** 得到私钥 */
        Key privateKey = kp.getPrivate();
        System.out.println("私钥:");
        System.out.println(DatatypeConverter.printHexBinary(privateKey.getEncoded()));

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

    public String encrypt(String toEncryptContent) {
        try {
            /** 将文件中的公钥对象读出 */
            Key publicKey = getSavedKey(PUBLIC_KEY_FILE_NAME);
            if (null == publicKey) {
                publicKey = generateKeyPair();
            }
            System.out.println("公钥");
            System.out.println(DatatypeConverter.printHexBinary(publicKey.getEncoded()));

            /** 得到Cipher对象来实现对源数据的RSA加密 */
            Cipher cipher = Cipher.getInstance(ALGORITHM_NAME);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] b = toEncryptContent.getBytes();
            /** 执行加密操作 */
            // ERROR:javax.crypto.IllegalBlockSizeException: Data must not be longer than 117 bytes
            byte[] encrypted = cipher.doFinal(b);
            Base64.Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String decrypt(String toDecryptContent) {
        try { /** 将文件中的私钥对象读出 */
            Key privateKey = getSavedKey(PRIVATE_KEY_FILE_NAME);
            if (null == privateKey) {
                return null;
            }
            System.out.println("私钥");
            System.out.println(DatatypeConverter.printHexBinary(privateKey.getEncoded()));

            /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
            Cipher cipher = Cipher.getInstance(ALGORITHM_NAME);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] b1 = decoder.decode(toDecryptContent);
            /** 执行解密操作 */
            byte[] decrypted = cipher.doFinal(b1);
            return new String(decrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}