package com.hades.example.java._3_serializable;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.serialization();
        test.deserialization();
    }

    // 序列化过程
    private void serialization() {
        try {
            User user = new User(1, "name_1");
            user.static_int_value = 100;
            user.transient_int_value = 200;
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("user.txt"));
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  反序列化过程
    public void deserialization() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("user.txt"));
            User user = (User) objectInputStream.readObject();
            System.out.println(user);
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
