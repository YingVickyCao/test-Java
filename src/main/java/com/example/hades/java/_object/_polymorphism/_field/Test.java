package com.example.hades.java._object._polymorphism._field;


public class Test {
    public static void main(String[] args) {
        Parent parent = new Child();
        System.out.println("parent.i = " + parent.i + ",parent.getI()=" + parent.getI());

        Child child = new Child();
        System.out.println("child.i = " + child.i + ",child.getI()=" + child.getI() + ",child.getSuperI()=" + child.getSuperI());
    }
}