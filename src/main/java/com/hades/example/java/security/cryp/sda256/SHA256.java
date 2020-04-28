package com.hades.example.java.security.cryp.sda256;

import javax.crypto.Cipher;
import java.io.*;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.util.Base64;

public class SHA256 {

    /**
     * 指定加密算法为DESede
     */
    private static String ALGORITHM_NAME = "RSA";
    /**
     * 指定key的大小
     */
    private static int KEY_SIZE = 1024;
    /**
     * 指定公钥存放文件
     */
    private static String PUBLIC_KEY_FILE = "PublicKey";
    /**
     * 指定私钥存放文件
     */
    private static String PRIVATE_KEY_FILE = "PrivateKey";

    /**
     * 生成密钥对
     */
    private void generateKeyPair() throws Exception {
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
        /** 得到私钥 */
        Key privateKey = kp.getPrivate();
        /** 用对象流将生成的密钥写入文件 */
        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(PUBLIC_KEY_FILE));
        ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(PRIVATE_KEY_FILE));

//        DatatypeConverter.printHexBinary(publicKey.getEncoded());
        saveKey(publicKey, PUBLIC_KEY_FILE);
        saveKey(publicKey, PUBLIC_KEY_FILE);

        oos1.writeObject(publicKey);
        oos2.writeObject(privateKey);

        /** 清空缓存，关闭文件输出流 */
        oos1.close();
        oos2.close();
    }

    private void saveKey(Key key, String fileName) {
        try {
            ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(fileName));
            oos1.writeObject(key);
            oos1.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 加密方法
     * source： 源数据
     */
    public String publicEncrypt(String source) {
        try {
            generateKeyPair();
            /** 将文件中的公钥对象读出 */
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PUBLIC_KEY_FILE));
            Key key = (Key) ois.readObject();
            ois.close();
            /** 得到Cipher对象来实现对源数据的RSA加密 */
            Cipher cipher = Cipher.getInstance(ALGORITHM_NAME);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] b = source.getBytes();
            /** 执行加密操作 */
            byte[] b1 = cipher.doFinal(b);
            Base64.Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(b1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 私钥加密方法
     * source： 源数据
     */
    public String privateEncrypts(String source) {
        try {
            generateKeyPair();
            /** 将文件中的公钥对象读出 */
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRIVATE_KEY_FILE));
            Key key = (Key) ois.readObject();
            ois.close();
            /** 得到Cipher对象来实现对源数据的RSA加密 */
            Cipher cipher = Cipher.getInstance(ALGORITHM_NAME);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] b = source.getBytes();
            /** 执行加密操作 */
            byte[] b1 = cipher.doFinal(b);
            Base64.Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(b1);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 解密算法
     * cryptograph:密文
     */
    public String privateDecrypt(String cryptograph) {
        try { /** 将文件中的私钥对象读出 */
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRIVATE_KEY_FILE));
            Key key = (Key) ois.readObject();
            /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
            Cipher cipher = Cipher.getInstance(ALGORITHM_NAME);
            cipher.init(Cipher.DECRYPT_MODE, key);
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] b1 = decoder.decode(cryptograph);
            /** 执行解密操作 */
            byte[] b = cipher.doFinal(b1);
            return new String(b);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 公钥解密算法
     * cryptograph:密文
     */
    public String publicDecrypt(String cryptograph) {
        try {
            /** 将文件中的私钥对象读出 */
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PUBLIC_KEY_FILE));
            Key key = (Key) ois.readObject();
            /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
            Cipher cipher = Cipher.getInstance(ALGORITHM_NAME);
            cipher.init(Cipher.DECRYPT_MODE, key);
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] b1 = decoder.decode(cryptograph);
            /** 执行解密操作 */
            byte[] b = cipher.doFinal(b1);
            return new String(b);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
