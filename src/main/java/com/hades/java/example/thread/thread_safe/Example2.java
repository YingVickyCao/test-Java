package com.hades.java.example.thread.thread_safe;

/**
 * 解决线程安全问题，方法2，加锁（synchronized）
 */
public class Example2 {

    volatile int a = 1;
    volatile int b = 1;

    public void add() {
//    public synchronized void add() {
        System.out.println("add start");
        for (int i = 0; i < 10000; i++) {
            a++;
            b++;
        }
        System.out.println("add done");
    }

    public void compare() {
//    public synchronized void compare() {
        System.out.println("compare start");
        for (int i = 0; i < 10000; i++) {
            //a始终等于b吗？
            if (a < b) {
                System.out.println("a:" + a + ",b:" + b + "," + (a > b));
                //最后的a>b应该始终是false吗？
            }
        }
        System.out.println("compare done");
    }
}