package com.hades.example.java._object._final._data;

public class FinalData {
    private int n1;
    private final int n2 = 21;
    private final int n3;
    public static final int n4 = 31;
//    public static final int n4;

    private A a1;
    private final A a2;
    public static final A a3 = new A(3);

    public FinalData(int n1, int n2, int n3, A a1, A a2) {
        this.n1 = n1;
//        this.n2 = n2;
        this.n3 = n3;
        this.a1 = a1;
        this.a2 = a2;
    }

    public void setN2(int n2) {
//        this.n2 = n2;
//        this.n3 = n2;
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
                ", n3=" + n3 +
                ", a1=" + a1 +
                ", a2=" + a2 +
                '}';
    }
}