package com.example.hades.java._object._overload._tostring;

public class Test {
    public static void main(String[] args) {
        C c4 = new C();
        c4.setFlag(false);
        c4.setC1("c1");

        // 方法1：重写toString
        // {c1 = c1}{flag=false, mNames=null}
        // 方法2： ToStringBuilder.reflectionToString(this):
        // com.example.hades.java._object._overload._tostring.C1@2503dbd3[c1=c1,flag=false,mNames=<null>]
        String str = c4.toString();
        System.out.println(str);

        // undefined和null没有toString()方法
//        undefined.toString(); // ERROR
//        null.toString();      // ERROR

//        String s = null;
//        s.toString();                 // ERROR:NullPointerException

//        StringBuffer stringBuffer = null;
//        stringBuffer.toString();      // ERROR:NullPointerException

//        StringBuilder stringBuilder = null;
//        stringBuilder.toString();     // NullPointerException

        Boolean flag = true;
        System.out.println(flag.toString());    // true
        flag = false;
        System.out.println(flag.toString());    // false

        String s = "abc";
        System.out.println(s);                  // abc
        System.out.println(s.toString());       // abc

        Integer integer = 5;
        System.out.println(integer.toString()); // 5

        Float f = 10.5f;
        System.out.println(f);              // 10.5
        System.out.println(f.toString());   // 10.5

        Double d = 10.5D;
        System.out.println(d);              // 10.5
        System.out.println(d.toString());   // 10.5
    }
}
