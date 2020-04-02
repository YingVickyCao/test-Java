package com.example.hades.java._object._overload._tostring;

public class C2 extends C1 {
    private String c2;

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append(super.toString());
        s.append("{c2 = ").append(c2).append("}");
        return s.toString();
    }
}
