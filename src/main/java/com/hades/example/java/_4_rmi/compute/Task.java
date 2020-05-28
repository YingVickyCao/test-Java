package com.hades.example.java._4_rmi.compute;

// The server in the example implements a generic compute engine, which the client uses to compute the value of the pi symbol
public interface Task<T> {
    T execute();
}