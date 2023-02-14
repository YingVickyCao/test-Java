package com.hades.java.example.serializable._serializable;

import java.io.Serializable;

class User implements Serializable {
    private static final long serialVersionUID = -4575083234166325540L;

    private int id;
    private House house;
    private transient String name;

    private static int score;

    public User() {
        System.out.println("User constructor");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        User.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", house=" + house +
                ", name='" + name + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
