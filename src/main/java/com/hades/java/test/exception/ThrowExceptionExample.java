package com.hades.java.test.exception;

public class ThrowExceptionExample {
    /**
     JVM 把异常抛给 test，test 不处理，JVM 继续往上抛抛给了 main。
     test 不处理，JVM 继续往上抛抛给了 main。
     main 不处理，又自动向上抛给了 JVM 虚拟机。
     JVM 发现它创建的对象又回到这里后，它的处理方案是中断程序。
     **/
    /**
     * 到了最上层还没有捕捉的地方，会发生什么？
     * 单线程由 main() 抛出，程序终止。
     * <p>
     * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
     * at com.hades.java.test.exception.ThrowExceptionExample.test(ThrowExceptionExample.java:16)
     * at com.hades.java.test.exception.ThrowExceptionExample.main(ThrowExceptionExample.java:11)
     */
    public static void main(String[] args) {
        ThrowExceptionExample example = new ThrowExceptionExample();
        example.test();
    }

    private void test() {
        int[] nums = {2, 3};
        int data = nums[3]; // ArrayIndexOutOfBoundsException
        System.out.println(data);
    }
}
