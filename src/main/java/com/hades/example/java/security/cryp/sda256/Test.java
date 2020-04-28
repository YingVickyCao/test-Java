package com.hades.example.java.security.cryp.sda256;

public class Test {

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        test.test();
    }
    public void test() {
        SHA256 sha256 = new SHA256();
        String source = "Hi123";//要加密的字符串
        String cryptograph = sha256.publicEncrypt(source);//生成的密文
        System.out.println("密文:\n" + cryptograph);
        String target = sha256.privateDecrypt(cryptograph);//解密密文
        System.out.println("解密后:\n" + target);
    }
}