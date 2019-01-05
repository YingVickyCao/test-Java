package com.example.hades.java.code._object._polymorphism._constructor_call_dynamic_bind_method;

/*
Parent constructor,START
Child.draw(),i=0
Parent constructor,END
~
Child constructor,i=5,START
Child constructor,i=5,END
 */
public class Test {
    public static void main(String[] args) {
        new Child(5);
    }
}