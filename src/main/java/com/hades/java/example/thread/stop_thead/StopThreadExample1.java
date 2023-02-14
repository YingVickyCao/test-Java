package com.hades.java.example.thread.stop_thead;

import java.util.concurrent.TimeUnit;

/**
 * java67.com/2015/07/how-to-stop-thread-in-java-example.html
 * 如何stop Thread？ 方法1：Using boolean volatile variable to stop a thread in Java
 */
public class StopThreadExample1 {
    public static void main(String[] args) throws InterruptedException {
        new StopThreadExample1().test();
    }

    private void test() throws InterruptedException {
        Server server = new Server();
        Thread thread = new Thread(server, "Server1");
        thread.start();

        System.out.println("Thread id:" + thread.getId() + ",thread name:" + thread.getName());

        TimeUnit.MILLISECONDS.sleep(100);
        server.exit();

        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Thread id:" + thread.getId() + ",thread name:" + thread.getName() + " is finished");
    }

    class Server implements Runnable {
        private volatile boolean isExit = false;

        @Override
        public void run() {
            while (!isExit) {
                System.out.println("Server is running...");
            }
            System.out.println("Server is stopped...");
        }

        public void exit() {
            isExit = true;
        }
    }
}
