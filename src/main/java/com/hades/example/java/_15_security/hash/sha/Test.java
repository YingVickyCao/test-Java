package com.hades.example.java._15_security.hash.sha;

import com.hades.example.java._15_security.Constants;

import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.test();
    }

    private void test() {
        SHATool tool = SHATool.getInstance();
        byte[] hashedBytes = tool.digest_string2bytes(Constants.toEncryptContent2);
        // [41, 108, 120, 124, -25, -24, 82, 76, -94, -33, -127, -115, -89, -73, -2, -77, 56, -73, -103, 68, 62, -107, 101, 95, 96, 34, -89, 49, 123, -119, -83, -115]
        System.out.println(Arrays.toString(hashedBytes));
        // 296C787CE7E8524CA2DF818DA7B7FEB338B799443E95655F6022A7317B89AD8D
        System.out.println(DatatypeConverter.printHexBinary(hashedBytes));

        String hashedString = tool.digest_string2string(Constants.toEncryptContent2);
        // 296c787ce7e8524ca2df818da7b7feb338b799443e95655f6022a7317b89ad8d
        System.out.println(hashedString);
    }
}