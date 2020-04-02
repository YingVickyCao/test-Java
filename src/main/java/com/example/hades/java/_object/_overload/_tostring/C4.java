package com.example.hades.java._object._overload._tostring;

public class C4 extends C3 {
    private String c4;

    public String getC4() {
        return c4;
    }

    public void setC4(String c4) {
        this.c4 = c4;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("{c4 = ").append(c4);
        s.append(",super=").append(super.toString()).append("}");
        return s.toString();
    }
}
