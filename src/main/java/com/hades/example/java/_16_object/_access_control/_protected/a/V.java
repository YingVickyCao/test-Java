package com.hades.example.java._16_object._access_control._protected.a;

public class V {
    private int n; // Recommended

    public V(int n) {
        this.n = n;
    }

    protected void set(int n) { // Recommended
        this.n = n;
    }

    @Override
    public String toString() {
        return "n=" + n;
    }
}