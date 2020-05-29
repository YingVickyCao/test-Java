package com.hades.example.java._4_rmi.engine;

import com.hades.example.java._4_rmi.compute.Compute;
import com.hades.example.java._4_rmi.compute.Task;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Declaring the Remote Interfaces Being Implemented
 */
public class ComputeEngine implements Compute {
    public ComputeEngine() {
        super();
    }

    /**
     * Providing Implementations for Each Remote Method
     */
    // This method implements the protocol between the ComputeEngine remote object and its clients
    // ComputeEngine executes each client's task and returns the result of the task's execute method directly to the client.
    @Override
    public <T> T executeTask(Task<T> t) throws RemoteException {
        // Arguments to or return values from remote methods can be of almost any type, including local objects, remote objects,
        // and primitive data types. More precisely, any entity of any type can be passed to or from a remote method as long as
        // the entity is an instance of a type that is a primitive data type, a remote object, or a serializable object
        System.out.println("executeTask,Compute@" + hashCode());
        System.out.println("executeTask,Task@" + t.hashCode());
        T result = t.execute();
        System.out.println("executeTask,result=" + result);
        return result;
    }

    @Override
    public int sum(int num1, int num2) {
        int result = num1 + num2;
        System.out.println("sum(" + num1 + "," + num2 + ")=" + result);
        return result;
    }

    /**
     * Implementing the Server's main Method
     */
    public static void main(String[] args) {
        /**
         * Creating and Installing a Security Manager
         */
        // The main method's first task is to create and install a security manager, which protects access to system resources
        // from untrusted downloaded code running within the Java virtual machine.
        // A security manager determines whether downloaded code has access to the local file system or can perform any other privileged operations.

        // If an RMI program does not install a security manager, RMI will not download classes (other than from the local class path) for objects
        // received as arguments or return values of remote method invocations.
//            System.setSecurityManager(new SecurityManager());
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Compute";
            /**
             * Making the Remote Object Available to Clients
             */
            Compute engine = new ComputeEngine();
            // The static UnicastRemoteObject.exportObject method exports the supplied remote object so that it can receive invocations of its remote methods from remote clients.
            // The second argument, an int, specifies which TCP port to use to listen for incoming remote invocation requests for the object. It is common to use the value zero, which specifies the use of an anonymous port.
            Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);

            // The system provides a particular type of remote object, the RMI registry, for finding references to other remote objects. The RMI registry is a simple remote object naming service that enables clients to
            // obtain a reference to a remote object by name. The registry is typically only used to locate the first remote object that an RMI client needs to use. That first remote object might then provide support for finding other objects.

            // ERROR:java.security.AccessControlException: access denied ("java.net.SocketPermission" "127.0.0.1:1099" "connect,resolve")
//            Registry registry = LocateRegistry.getRegistry();
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println("Server registe");
            // The code then adds the name to the RMI registry running on the server.
            registry.rebind(name, stub);
            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}
