package com.hades.java.example.thread.thread_safe;

public class TestExample2 {
    public static void main(String[] args) {
//        test1();
        test2();
        test3();
    }

    private static void test1() {
        //  同一个线程，a 和 b 数值一样
        //  加锁，不加锁，效果是一样的
        /**
         * add start
         * add done
         * compare start
         * compare done
         */
        Example2 example2 = new Example2();
        example2.add();
        example2.compare();
    }

    private static void test2() {
        //  同一个线程，a 和 b 数值一样
        //  加锁，不加锁，效果是一样的
        /**
         * add start
         * add done
         * compare start
         * compare done
         */
        Example2 example2 = new Example2();
        Thread thread = new Thread(() -> {
            example2.add();
            example2.compare();
        });
        thread.start();
    }

    private static void test3() {
        /**
         * 测试结果 1：
         * add start
         * compare start
         * a:3374,b:5283,false
         * add done
         * compare done
         *
         *
         * 测试结果 2：
         * add start
         * compare start
         * a:4695,b:5121,false
         * a:8890,b:8988,false
         * add done
         * compare done
         *
         * 每次运行结果都不一样。
         *
         * 原因：
         * 因为两个线程是交错执行 add 和 compare 方法中的业务逻辑，而且这些业务逻辑不是原子性的：
         * a++ 和 b++ 操作中可以穿插在 compare 方法的比较代码中；
         * a<b 这种比较操作在字节码层面是加载 a、加载 b 和比较三步，代码虽然是一行但也不是原子性的。
         *
         * 解决：
         * 为 add 和 compare 都加上方法锁，确保 add 方法执行时，compare 无法读取 a 和 b：
         *
         * 注意：
         * 加锁之前，弄清楚线程、业务逻辑和锁三者之间的关系
         */
        Example2 example2 = new Example2();
        new Thread(() -> example2.add()).start();
        new Thread(() -> example2.compare()).start();
    }
}
