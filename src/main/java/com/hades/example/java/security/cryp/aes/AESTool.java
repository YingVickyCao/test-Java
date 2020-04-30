package com.hades.example.java.security.cryp.aes;

import com.hades.example.java.security.hash.base64.Base64Tool;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AESTool {
    private static volatile AESTool mInstance;

    public static AESTool getInstance() {
        if (null == mInstance) {
            synchronized (AESTool.class) {
                if (null == mInstance) {
                    mInstance = new AESTool();
                }
            }
        }
        return mInstance;
    }

    private static final String ALGORITHM_NAME = "AES";
    /**
     * 加密算法/加密模式/填充类型
     */
    private static final String CIPHER_MODE = "AES/ECB/PKCS5Padding";

    /**
     * 设置iv偏移量
     * 本例采用ECB加密模式，不需要设置iv偏移量
     */
    private static final String IV_ = null;
    /**
     * 设置加密密码处理长度。
     * 不足此长度补0；
     */
    private static final int PWD_SIZE = 16;

    /**
     * 密码处理方法
     * 如果加解密出问题,先查看本方法，排除密码长度不足填充0字节,导致密码不一致
     *
     */
    private byte[] checkPassword(byte[] bytes) {
        if (bytes == null){
            bytes = new byte[PWD_SIZE];
        }
        byte[] data = null;
            if (bytes.length < PWD_SIZE) {
                System.arraycopy(bytes, 0, data = new byte[PWD_SIZE], 0, bytes.length);
            } else {
                data = bytes;
            }
        return data;
    }

    public byte[] encrypt(byte[] clearTextBytes, byte[] pwd) {
        byte[] pwdBytes = checkPassword(pwd);
        try {
            // 1 获取加密密钥
            SecretKeySpec keySpec = new SecretKeySpec(pwdBytes, ALGORITHM_NAME);
//            System.out.println(keySpec.getEncoded());
//            System.out.println(keySpec.getFormat());    // RAW

            // 2 获取Cipher实例
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);

            // 查看数据块位数 默认为16（byte） * 8 =128 bit
//            System.out.println("数据块位数(byte)：" + cipher.getBlockSize());

            // 3 初始化Cipher实例。设置执行模式以及加密密钥
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);

            // 4 执行
            byte[] cipherTextBytes = cipher.doFinal(clearTextBytes);

            // 5 返回密文字符集
            return cipherTextBytes;

        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] decrypt(byte[] cipherTextBytes, byte[] pwd) {
        byte[] pwdBytes = checkPassword(pwd);

        try {
            // 1 获取解密密钥
            SecretKeySpec keySpec = new SecretKeySpec(pwdBytes, ALGORITHM_NAME);

            // 2 获取Cipher实例
            Cipher cipher = Cipher.getInstance(CIPHER_MODE);

            // 查看数据块位数 默认为16（byte） * 8 =128 bit
//            System.out.println("数据块位数(byte)：" + cipher.getBlockSize());

            // 3 初始化Cipher实例。设置执行模式以及加密密钥
            cipher.init(Cipher.DECRYPT_MODE, keySpec);

            // 4 执行
            byte[] clearTextBytes = cipher.doFinal(cipherTextBytes);

            // 5 返回明文字符集
            return clearTextBytes;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 解密错误 返回null
        return null;
    }

    /**
     * BASE64加密
     *
     * @param clearText 明文，待加密的内容
     * @param password  密码，加密的密码
     * @return 返回密文，加密后得到的内容。加密错误返回null
     */
    public String encryptWithBase64(String clearText, String password) {
        try {
            // 1 获取加密密文字节数组
            byte[] cipherTextBytes = encrypt(clearText.getBytes(StandardCharsets.UTF_8), password.getBytes(StandardCharsets.UTF_8));

            // 2 对密文字节数组进行BASE64 encoder 得到 BASE6输出的密文
            return Base64Tool.getInstance().encodeToString2(cipherTextBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 加密错误 返回null
        return null;
    }

    public String decryptWithBase64(String cipherText, String password) {
        try {
            // 1 对 BASE64输出的密文进行BASE64 decodebuffer 得到密文字节数组
            byte[] cipherTextBytes = Base64Tool.getInstance().decode(cipherText);

            // 2 对密文字节数组进行解密 得到明文字节数组
            byte[] clearTextBytes = decrypt(cipherTextBytes, password.getBytes(StandardCharsets.UTF_8));

            // 3 根据 CHARACTER 转码，返回明文字符串
            return new String(clearTextBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 解密错误返回null
        return null;
    }

    public String encryptWithHex(String clearText, String password) {
        try {
            // 1 获取加密密文字节数组
            byte[] cipherTextBytes = encrypt(clearText.getBytes(StandardCharsets.UTF_8), password.getBytes(StandardCharsets.UTF_8));

            // 2 对密文字节数组进行 转换为 HEX输出密文
            String cipherText = byte2hex(cipherTextBytes);

            // 3 返回 HEX输出密文
            return cipherText;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 加密错误返回null
        return null;
    }

    public String decryptHexWith(String cipherText, String password) {
        try {
            // 1 将HEX输出密文 转为密文字节数组
            byte[] cipherTextBytes = hex2byte(cipherText);

            // 2 将密文字节数组进行解密 得到明文字节数组
            byte[] clearTextBytes = decrypt(cipherTextBytes, password.getBytes(StandardCharsets.UTF_8));

            // 3 根据 CHARACTER 转码，返回明文字符串
            return new String(clearTextBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 解密错误返回null
        return null;
    }

    /*字节数组转成16进制字符串  */
    public String byte2hex(byte[] bytes) { // 一个字节的数，
        StringBuffer sb = new StringBuffer(bytes.length * 2);
        String tmp = "";
        for (int n = 0; n < bytes.length; n++) {
            // 整数转成十六进制表示
            tmp = (java.lang.Integer.toHexString(bytes[n] & 0XFF));
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
        }
        return sb.toString().toUpperCase(); // 转成大写
    }

    /*将hex字符串转换成字节数组 */
    private byte[] hex2byte(String str) {
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        str = str.toLowerCase();
        int l = str.length() / 2;
        byte[] result = new byte[l];
        for (int i = 0; i < l; ++i) {
            String tmp = str.substring(2 * i, 2 * i + 2);
            result[i] = (byte) (Integer.parseInt(tmp, 16) & 0xFF);
        }
        return result;
    }
}
