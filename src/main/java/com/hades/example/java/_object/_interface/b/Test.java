package com.hades.example.java._object._interface.b;

import com.hades.example.java._object._interface.a.Child;
import com.hades.example.java._object._interface.a.IInfo;

public class Test {
    public static void main(String[] args) {
//        Parent parent = new Parent();

        Child p = new Child();
        System.out.println(p.what());
        p.print();
        System.out.println();

        IInfo p2 = new Child();
        System.out.println(p2.what());
        p2.print();
        System.out.println(p2.n);
    }
}