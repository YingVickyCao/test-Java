package com.hades.example.java._3_serializable;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
//    private int num;
    public static int static_int_value;
    public transient int transient_int_value;

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

//    public User(int id, String name, int num) {
//        this.id = id;
//        this.name = name;
//        this.num = num;
//    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public int getNum() {
//        return num;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", num=" + num +
                '}';
    }
}