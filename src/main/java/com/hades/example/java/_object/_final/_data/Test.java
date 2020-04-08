package com.hades.example.java._object._final._data;

public class Test {
    public static void main(String[] args) {
        FinalData finalData = new FinalData(12, 22, 32, new A(12), new A(22));
        finalData.setN2(23);
        finalData.setA1(new A(13));
        finalData.setA2Value(23);
        System.out.println(finalData.toString());

        // ERROR: Cannot assign a value to final variable n3
//        finalData.n4 = 41;
//        finalData.n3 = 33;
    }
}