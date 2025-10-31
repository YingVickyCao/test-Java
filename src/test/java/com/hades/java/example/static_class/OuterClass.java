package com.hades.java.example.static_class;


/**
 * https://mp.weixin.qq.com/s?__biz=Mzg3ODY2MzU2MQ==&mid=2247488726&idx=3&sn=e8a93c702a67c799160945c5204f2b72&chksm=cf111630f8669f264858291487ba36a7ceb49c2b2f954708d4657fcd4f55d9e3f2fc4ff514d3&token=1436311520&lang=zh_CN#rd
 */
class TestOuterClass {
    public static void main(String[] args) {
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass();

        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass2 innerClass2 = outerClass.new InnerClass2();
    }
}

public class OuterClass {
    int i;
    static int staticI;

    public void test() {

    }

    public static void staticTest() {

    }

    static class InnerClass {
        /**
         * 静态内部类不能访问外部类的非静态成员，只能访问静态成员。
         * 静态内部类的实例创建不依附于其外部类实例。
         */
        public void method() {
            // i = 10; //  不能调用
            // test()  //  不能调用
            staticI = 10;
            staticTest();

        }
    }

    class InnerClass2 {
        /**
         * 普通内部类能访问外部类的静态和非静态成员。
         * 普通内部类的实例创建依附于其外部类实例。
         */
        public InnerClass2() {
            i = 10;
        }

        public void method() {
            i = 10;
            test();
            staticI = 10;
            staticTest();

        }
    }
}