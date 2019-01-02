package com.example.hades.java.code._object._final._data;

public class FinalData {
//    private int n1;
    private int n1 = 11;
    public final int n2;
    public static final int n3 = 3;
//    public static final int n3;

    private A a1;
    private final A a2;
    public static final A a3 = new A(3);

    public FinalData(int n1, int n2, A a1, A a2) {
        this.n1 = n1;
        this.n2 = n2;
        this.a1 = a1;
        this.a2 = a2;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public void setA1(A a1) {
        this.a1 = a1;
    }

    public void setA2Value(int i) {
        a2.i = i;
    }

    @Override
    public String toString() {
        return "{" +
                "n1=" + n1 +
                ", n2=" + n2 +
                ", a1='" + a1 + '\'' +
                ", a2='" + a2 + '\'' +
                '}';
    }
}