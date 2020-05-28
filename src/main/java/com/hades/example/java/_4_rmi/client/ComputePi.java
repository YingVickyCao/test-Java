package com.hades.example.java._4_rmi.client;

import com.hades.example.java._4_rmi.compute.Compute;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * ComputePi, looks up and invokes a Compute object
 */
public class ComputePi {
    public static void main(String args[]) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Compute";
//            Registry registry = LocateRegistry.getRegistry(args[0]);
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Compute comp = (Compute) registry.lookup(name);
            System.out.println("Compute@" + comp.hashCode());

//            Pi task = new Pi(Integer.parseInt(args[1]));
            Pi task = new Pi(10);
            System.out.println("start request of pi");
            int sum = comp.sum(1, 5);
            System.out.println(sum);
            BigDecimal pi = comp.executeTask(task);
            System.out.println(pi);
            System.out.println("receive response of pi");
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }
}