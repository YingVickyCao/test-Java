package com.hades.java.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * https://mp.weixin.qq.com/s?__biz=Mzg3ODY2MzU2MQ==&mid=2247488742&idx=1&sn=44fd4ca0e6565caf3076d5cc4737d53d&chksm=cf111600f8669f168237bcb8aa65415b1aad29a74abdb9518c8d820f219cc332c47cec5d545d&token=1436311520&lang=zh_CN#rd
 * <p>
 * 使用equals和==进行比较的区别？
 */
public class CompareTest {
    /**
     * ==
     * 对于基本类型，比较的是数值是否相同。
     * 对于引用类型，比较的是内存地址是否相同。
     */
    @Test
    public void test_1() {

        int a = 10;
        int b = 10;
        Assert.assertTrue(a == b);

        {
            Stu stu = new Stu(10);
            Stu stu2 = new Stu(10);
            Assert.assertFalse(stu == stu2);
        }


        {
            Stu2 stu = new Stu2(10);
            Stu2 stu2 = new Stu2(10);
            Assert.assertFalse(stu == stu2);
        }

        {
            String s1 = new String("abc");
            String s2 = new String("abc");
            Assert.assertFalse(s1 == s2);
        }
    }

    /**
     * equals：判断对象的内存地址是否相同。
     * 若没有重写此方法，和 == 相同。
     * 若重写了此方法，按equals方法的逻辑判断内容是否相等。比如：String 重写了equals方法来判断字符串内容是否一样。
     */
    @Test
    public void test_2() {
        {
            Stu stu = new Stu(10);
            Stu stu2 = new Stu(10);
            Assert.assertFalse(stu.equals(stu2));
        }


        {
            Stu2 stu = new Stu2(10);
            Stu2 stu2 = new Stu2(10);
            Assert.assertTrue(stu.equals(stu2));
        }

        {
            String s1 = new String("abc");
            String s2 = new String("abc");
            Assert.assertTrue(s1.equals(s2));
        }
    }
}

class Stu {
    int a;

    public Stu(int a) {
        this.a = a;
    }
}

class Stu2 {
    int a;

    public Stu2(int a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stu2 stu2 = (Stu2) o;
        return a == stu2.a;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(a);
    }
}
