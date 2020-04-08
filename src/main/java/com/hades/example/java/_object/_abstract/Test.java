package com.hades.example.java._object._abstract;

public class Test {
    public static void main(String[] args){
//        Parent parent = new Parent();

        Parent p = new Child();
        System.out.println(p.what());
        p.print();
    }
}