package com.hades.example.java._16_object._polymorphism._constructor_call_dynamic_bind_method;

/*
Grain constructor,START
Wheat.draw(),i=0
Grain constructor,END
~
Wheat constructor,i=5,START
Wheat constructor,i=5,END
 */
public class Test {
    public static void main(String[] args) {
        new Child(5);
    }
}