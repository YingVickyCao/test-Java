package com.hades.example.java._16_object._compare;

import java.util.Objects;

public class Stu {
    int age;
    String name;
    int id;

    public Stu(int age, String name, int id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public Stu(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stu stu = (Stu) o;
        return
//                age == stu.age &&
                id == stu.id && Objects.equals(name, stu.name);
    }

    @Override
    public int hashCode() {
//        return Objects.hash(age, name, id);
        return Objects.hash(name, id);
    }

}
