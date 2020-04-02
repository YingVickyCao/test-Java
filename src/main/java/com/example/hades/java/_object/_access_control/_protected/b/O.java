package com.example.hades.java._object._access_control._protected.b;

import com.example.hades.java._object._access_control._protected.a.V;

public class O extends V {
    private String name;

    public O(int n, String name) {
        super(n);
        this.name = name;
    }

    public void set(int n, String name) {
        set(n);// Recommended
        this.name = name;
    }

    @Override
    public String toString() {
        return "name=" + name + ',' + super.toString();
    }

    public static void main(String[] args) {
        O o = new O(10, "A");
        System.out.println(o.toString());

        o.set(100, "C");
        System.out.println(o.toString());
    }
}
