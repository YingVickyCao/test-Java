package com.hades.example.java._object._polymorphism._covariantReturn;

public class Test {
    public static void main(String[] args) {
        Mill mill = new Mill();
        Grain grain = mill.process();

        System.out.println(grain.toString());

        mill = new WheatMill();
        grain = mill.process();
        System.out.println(grain.toString());
    }
}