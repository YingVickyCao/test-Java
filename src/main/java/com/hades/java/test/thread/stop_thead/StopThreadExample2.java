package com.hades.java.test.thread.stop_thead;

import java.util.concurrent.TimeUnit;

/**
 * https://codeahoy.com/java/How-To-Stop-Threads-Safely/
 * 如何stop Thread？ 方法2：Thread.interrupt()stop thread。isInterrupted()判断是否该结束thread
 */
public class StopThreadExample2 {
    public static void main(String[] args) throws InterruptedException {
        new StopThreadExample2().test();
    }

    private void test() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Server is running...");
                }
                System.out.println("Server is stopped...");
            }
        });
        thread.start();

        System.out.println("Thread id:" + thread.getId() + ",thread name:" + thread.getName());

        TimeUnit.MILLISECONDS.sleep(100);
        thread.interrupt();

        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Thread id:" + thread.getId() + ",thread name:" + thread.getName() + " is finished");
    }
}