package com.example.hades.java._object._overload._tostring;

public class Test {
    public static void main(String[] args) {
        C4 c4 = new C4();
        c4.setFlag(false);
        c4.setC1("c1");
        c4.setC2("c2");
        c4.setC3("c3");
        c4.setC4("c4");

        String str = c4.toString();
        System.out.println(str);
    }
}
