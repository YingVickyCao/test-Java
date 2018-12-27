package com.example.hades.java.code._object._access_control._multi_class.a;

public class A {
    private int a;
    private H h3;

//    A(int a) {
    public A(int a) {
        this.a = a;
        h3 = new H("H3");
        System.out.println(h3.s);
    }

//    int getA() {
    public int getA() {
        System.out.println(h3.s);
        return a;
    }

//    H getH() {
    public H getH() {
        return h3;
    }

//    class H {
    public class H {
        String s;
//        private String s;

//        H(String s) {
        public H(String s) {
            this.s = s;
        }

//        String getH() {
        public String getH() {
            return s;
        }
    }
}