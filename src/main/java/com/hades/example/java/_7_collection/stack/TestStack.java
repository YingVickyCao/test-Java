package com.hades.example.java._7_collection.stack;

public class TestStack {

    public static void main(String[] args) {
        StringCache cache = StringCache.getInstance();
        cache.addString("A"); // A
        cache.addString("B"); // A, B
        cache.addString("C"); // A, B, C

        // pop:后进先出
        cache.getCurrentString();   // C
        cache.removeCurrentString();  // A, B,C -> A, B
        cache.removeString("A");  // A,B -> B
        cache.removeString("B");  // B -> empty
    }
}
