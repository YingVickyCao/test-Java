package com.hades.java.example.serializable._3;

import java.io.Serializable;

class User implements Serializable {
    private static final long serialVersionUID = -4575083234166325540L;

    private int id;

    public User() {
        System.out.println("User constructor");
    }

    public int getId() {
        return id;
    }

    public void setId(int num) {
        this.id = num;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }
}
