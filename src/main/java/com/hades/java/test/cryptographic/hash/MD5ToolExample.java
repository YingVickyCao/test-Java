package com.hades.java.test.cryptographic.hash;

import java.util.ArrayList;
import java.util.List;

public class MD5ToolExample {
    public static void main(String[] args) {
        MD5Tool tool = new MD5Tool();
        String result = tool.digest("888qtqyhh");
        System.out.println(result); // 结果可以有大写，也可以有小写。

        char[] chars = result.toCharArray();
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; (i+1) < chars.length; i = i + 1) {
            // value is in  ASCII
            if (('0' <= chars[i] && chars[i] <= '9') && ('A' <= chars[i + 1] && chars[i + 1] < 'Z')) {
                characterList.add(chars[i]);
                characterList.add(chars[i + 1]);
            }
        }
        System.out.println(characterList);
    }
}