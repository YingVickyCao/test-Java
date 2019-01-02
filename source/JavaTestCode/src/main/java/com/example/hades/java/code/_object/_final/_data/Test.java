package com.example.hades.java.code._object._final._data;

public class Test {
    public static void main(String[] args) {
        FinalData finalData = new FinalData(1, 2, new A(1), new A(2));
        finalData.setN1(11);
        finalData.setA1(new A(11));
        finalData.setA2Value(22);
        System.out.println(finalData.toString());

        // ERROR: Cannot assign a value to final variable n2
//        finalData.n3 = 3;
//        finalData.n2 = 22;
    }
}