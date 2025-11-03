package com.hades.java.example;

/**
 * https://mp.weixin.qq.com/s?__biz=Mzg3ODY2MzU2MQ==&mid=2247488726&idx=4&sn=f127d7b22cbd59cc8de3e137bdd5b10d&chksm=cf111630f8669f2609cc4d4a2ad084b67c7d992ea2a2da39afe62ec30cfa62b6bb26b2e56707&token=1436311520&lang=zh_CN#rd
 * <p>
 * Java中在传参数时是将值进行传递，还是传递引用？
 */
public class TransferTest {
    public static void main(String[] args) {
        int num = 1;
        changeNum(num);
        System.out.println(num); // 1

        Person person = new Person();
        System.out.println(person); // Person@251a69d7
        change(person);
        System.out.println(person); // Person@251a69d7
    }

    public static void changeNum(int x) {
        /**
         * 在方法调用时，参数是基本数据类型，按值传递
         */
        x = 2;
    }

    public static void change(Person p) {
        /**
         * 在方法调用时，参数是引用类型，按值传递
         */
        p = new Person();
    }
}

class Person {

}
