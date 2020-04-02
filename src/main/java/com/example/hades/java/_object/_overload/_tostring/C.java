package com.example.hades.java._object._overload._tostring;

public class C extends P {
    private String c1;

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    // 方法2：
//    @Override
//    public String toString() {
//        StringBuffer s = new StringBuffer();
//        s.append("{c1 = ").append(c1).append("}");
//        s.append(super.toString());
//        return s.toString();
//    }
}
