package com.hades.example.java._4_rmi.compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Any object that implements this interface(Remote) can be a remote object.
public interface Compute extends Remote {
    //  executeTask method is a remote method
    //  变量和返回值 6必须是java.io.Serializable， or primitive type
    <T> T executeTask(Task<T> t) throws RemoteException;

    int sum(int num1, int num2) throws RemoteException;
}