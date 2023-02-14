package com.hades.java.example.exception;

public class ThrowExceptionExample2 {
    /**
     * 到了最上层还没有捕捉的地方，会发生什么？
     * 多线程由 Thread.run() 抛出，该线程终止，但程序不终止。
     *
     * Exception in thread "Thread-0" java.lang.ArrayIndexOutOfBoundsException: 3
     * at com.hades.java.test.exception.ThrowExceptionExample2.test(ThrowExceptionExample2.java:35)
     * at com.hades.java.test.exception.ThrowExceptionExample2.access$000(ThrowExceptionExample2.java:3)
     * at com.hades.java.test.exception.ThrowExceptionExample2$1.run(ThrowExceptionExample2.java:14)
     * at java.lang.Thread.run(Thread.java:748)
     * 1640266255994
     * 1640266256997
     * 1640266257997
     * 1640266259000
     * 1640266260002
     * 1640266261003
     * 1640266262004
     */
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ThrowExceptionExample2 example = new ThrowExceptionExample2();
                example.test();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(System.currentTimeMillis());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void test() {
        int[] nums = {2, 3};
        int data = nums[3]; // ArrayIndexOutOfBoundsException
        System.out.println(data);
    }
}
