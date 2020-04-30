package com.hades.example.java.security.cryp.dec;

import com.hades.example.java._framework.Log;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class DesTool {
    private static final String TAG = DesTool.class.getSimpleName();

    public final static String TO_ENCRYPT_CONTENT = "Hi123";
    public final static byte[] TO_DECRYPT_CONTENT = new byte[]{121, 53, 22, 92, -126, -93, -79, 94};

    private final String ALGORITHM_NAME = "DES";
    private final String KEY = "abcdedfh"; // 密钥(8 bytes) = [97, 98, 99, 100, 101, 100, 102, 104]

    public byte[] encrypt(byte[] toEncryptContent) {
        return crypto(Cipher.ENCRYPT_MODE, toEncryptContent);
    }

    public byte[] decrypt(byte[] toDecryptContent) {
        return crypto(Cipher.DECRYPT_MODE, toDecryptContent);
    }

    public byte[] crypto(int mode, byte[] content) {
        byte[] keyData = KEY.getBytes();
        if (8 != keyData.length) {
            Log.d(TAG, "Dec encrypt or decrypt error, key must be 8 bytes. current invalid key=" + KEY);
            return null;
        }

        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM_NAME);

            // Convert key
            DESKeySpec keySpec = new DESKeySpec(KEY.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM_NAME);
            SecretKey key = keyFactory.generateSecret(keySpec);

            cipher.init(mode, key); //  加密 or 解密

            return cipher.doFinal(content); // 返回加密 or 解密后的内容
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}