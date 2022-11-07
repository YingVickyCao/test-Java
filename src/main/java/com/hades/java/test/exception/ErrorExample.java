package com.hades.java.test.exception;

public class ErrorExample {
    public static void main(String[] args) {
        byte[] data = new byte[1021 * 1024 * 1024];
        byte result ;
        for (int i = 0; i < data.length; i++) {
            result = data[i];
            System.out.println(result);
        }
        System.out.println(data);
    }
}
