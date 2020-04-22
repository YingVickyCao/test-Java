package com.hades.example.java.security.md5;

public class TestMD5 {
    MD5 md5 = new MD5();

    public static void main(String[] args) {
        TestMD5 testMD5 = new TestMD5();
        testMD5.test();
    }

    private void test() {
        String decryptedUserInputPassword = "apple";
        String userInputName = "ABC";

        String hashedOfDecryptedUserInputPassword = md5.hash(decryptedUserInputPassword);
        System.out.println(hashedOfDecryptedUserInputPassword);

        boolean isInValid = serverCheckPassword(decryptedUserInputPassword, hashedOfDecryptedUserInputPassword, userInputName);
        System.out.println(isInValid);
    }

    /**
     * @param decryptedUserInputPassword         用户输入的、加密后的密码
     * @param hashedOfDecryptedUserInputPassword 加密后的密码，然后经过 MD5 hash 处理
     * @param userName
     * @return
     */
    public boolean serverCheckPassword(String decryptedUserInputPassword, String hashedOfDecryptedUserInputPassword, String userName) {
        /**
         * 验证数据完整性
         * false = 收到的数据不完整，应掉丢
         */
        if (!hashedOfDecryptedUserInputPassword.equals(md5.hash(decryptedUserInputPassword))) {
            return false;
        }

        /**
         * 验证传过来的密码，是否与DB存储的密码一致
         */
        String decryptedPassword = getPasswordFromDB(userName);
        return null != decryptedPassword && decryptedPassword.equals(decryptedUserInputPassword);
    }

    /**
     * @param userName 用户名
     * @return 加密后的密码
     */
    private String getPasswordFromDB(String userName) {
        if (MD5.USER_NAME.equals(userName)) {
            return MD5.USER_PASSWORD_DECRYPTED;
        }
        return null;
    }
}