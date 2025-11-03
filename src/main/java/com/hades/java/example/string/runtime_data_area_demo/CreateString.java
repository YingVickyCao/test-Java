package com.hades.java.example.string.runtime_data_area_demo;


/**
 * https://mp.weixin.qq.com/s?__biz=Mzg3ODY2MzU2MQ==&mid=2247488742&idx=2&sn=8cb474744271ba84cc82a4c5ea6f9da3&chksm=cf111600f8669f16d322070c2c80a19631ea60427998a5a886e7d19cbf20eaf9c1551d56ebbb&token=1436311520&lang=zh_CN#rd
 * <p>
 * String s = new String("xxx");创建了几个String对象?
 */
public class CreateString {
    /*
      同义词：
      字符串字面量池 (String Literal Pool)
      String Pool
      字符串常量池 (String Constant Pool)
      运行时字符串常量池： 此处指在 JVM 堆内存中的一个特殊区域，叫做 String Pool，用来存储字符串对象，简称常量池。
     */
    public static void test() {
          /*
            String s1 = "Hello";

            第1步：处理“Hello”（字面值）
            JVM在String Pool中查找是否已经存在内容为“Hello“的String对象。
            如果 String Pool 中存在 "Hello" 对象： JVM 会复用这个已存在的对象。
            如果 String Pool 中不存在 "Hello" 对象： JVM 会在 堆 (Heap) 上创建一个新的 String 对象（内容为 "Hello"），并将这个对象 放入 String Pool 中。

            第2步：s1 将用于 引用 一个 String 对象。
            它存储的是 第2步 中获取的“Hello”字符串（无论是 String Pool 中复用的还是新创建的）的内存地址。
         */
        String s1 = "Hello";
        String s2 = "Hello";
        /*
             String s3 = new String("Hello");

             第1步：处理构造函数的参数“Hello”（字面值）
             JVM在String Pool中查找是否已经存在内容为“Hello“的String对象。
             如果 String Pool 中存在 "Hello" 对象： JVM 会复用这个已存在的对象。
             如果 String Pool 中不存在 "Hello" 对象： JVM 会在 堆 (Heap) 上创建一个新的 String 对象（内容为 "Hello"），并将这个对象 放入 String Pool 中。

             第2步：使用 new 关键字创建新的 String 对象。
             使用 new 关键字在堆内存中分配一个块新的内存空间用来创建新的 String 对象。
             该对象的内容，会从第一步中获取的"Hello" 字符串（无论是 String Pool 中复用的还是新创建的）的内容来初始化。
             *
             第3步：引用变量 s3
             String s3 = ...; 中的 s3 是一个 引用变量。
             它存储的是 第2步 中在堆上新创建的 String 对象的内存地址。
         */
        String s3 = new String("Hello");
        String s4 = new String("Hello World");
        /**
         2060468723
         2060468723
         622488023
         1933863327

         2060468723
         622488023
         */
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s3));
        System.out.println(System.identityHashCode(s4));
        // 尝试将 newHello 对象放入 String Pool，并返回 String Pool 中的对应对象
        s3.intern();
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s3));
    }

    public static void main(String[] args) {
        test();
    }
}
