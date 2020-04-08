package com.hades.example.java._op._arithmetic;

public class Value {
    int i;


    @Override
    public boolean equals(Object obj) {
        if (null != obj) {
            if (obj instanceof Value) {
                Value tmp = (Value) obj;
                return tmp.i == this.i;
            }
        }
        return false;
    }
}
