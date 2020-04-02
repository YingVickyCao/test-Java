package com.example.hades.java._object._overload._tostring;

public class C3 extends C2 {
    private String c3;

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append(super.toString());
        s.append("{c3 = ").append(c3).append("}");
        return s.toString();
    }
}
