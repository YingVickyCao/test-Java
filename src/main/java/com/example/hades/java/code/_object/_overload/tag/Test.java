package com.example.hades.java.code._object._overload.tag;

public class Test {
    public static void main(String[] args) {
        System.out.println(A1.TAG1); // A1
        System.out.println(A1.TAG2); // com.example.hades.java.code._object._overload.tag.A1
        A1 a1 = new A1();
        System.out.println(a1.getTag1());   // A1
        System.out.println(a1.getTag2());   // com.example.hades.java.code._object._overload.tag.A1
        System.out.println();

        System.out.println(A2.TAG1); // A2
        System.out.println(A2.TAG2);  // com.example.hades.java.code._object._overload.tag.A2
        A2 a2 = new A2();
        System.out.println(a2.getTag1());// A1
        System.out.println(a2.getTag2());// com.example.hades.java.code._object._overload.tag.A2

        A1 a3 = new A2();
        System.out.println(a3.getTag1());// A1
        System.out.println(a3.getTag2());// com.example.hades.java.code._object._overload.tag.A2
    }
}
