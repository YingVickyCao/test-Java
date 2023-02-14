package com.hades.java.example.serializable._3;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 测试：transient 修饰 字段name，那么，序列化时会忽略name
 */
public class SerializeExample {
    public static void main(String[] args) {
        SerializeExample example = new SerializeExample();
        example.test();
    }

    String filePath = "user.txt";

    private void test() {
        serialize();
    }

    private void serialize() {
        User user = new User();
        user.setId(1);

        ObjectOutputStream outStream;
        ObjectInputStream inStream;
        try {
            outStream = new ObjectOutputStream(new FileOutputStream(filePath));
            outStream.writeObject(user);
            outStream.flush();
            outStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
