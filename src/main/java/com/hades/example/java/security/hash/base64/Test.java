package com.hades.example.java.security.hash.base64;


import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) {
        new Test().test();
    }

    private void test() {
        Base64Util base64Util = Base64Util.getInstance();

        String src = "字串文字";
        byte[] src2 = src.getBytes(StandardCharsets.UTF_8);

        String dest = base64Util.encodeToString(src);
        System.out.println(dest);   //  5a2X5Liy5paH5a2X

        String dest3 = base64Util.encodeToString2(src2);
        System.out.println(dest3);  // 5a2X5Liy5paH5a2X

        byte[] dest2 = base64Util.encode(src2);
        System.out.println(new String(dest2, StandardCharsets.UTF_8));  //  5a2X5Liy5paH5a2X
    
        // ------

        String src3 = base64Util.decodeToString(dest);
        System.out.println(src3);           // 字串文字

        byte[] src4 = base64Util.decode(dest);
        System.out.println(new String(src4, StandardCharsets.UTF_8));   // 字串文字

        byte[] src5 = base64Util.decode(dest2);
        System.out.println(new String(src5, StandardCharsets.UTF_8));   // 字串文字
    }
}
