package com.hades.java.example._generic_type;

import java.util.ArrayList;
import java.util.List;

/**
 * 范型擦除
 * https://mp.weixin.qq.com/s?__biz=Mzg3ODY2MzU2MQ==&mid=2247488758&idx=4&sn=529f9b5fe86d48232453084e846fe6d5&chksm=cf111610f8669f0626c6a2a1cef9bcb869a98c99c5dee894b2f0e1a872845eccc5aeabd16913&token=1436311520&lang=zh_CN#rd
 */
public class _9_ensure {
    public static void main(String[] args) {
        Parent<String> p = new Child();
        p.setSrc("abc");


        {
//            List<String> strs = new ArrayList<Integer>(); // 编译失败
//            List<Object> objects = strs; // 编译失败
        }

        {
            List<String> strs = new ArrayList<String>();
//            List<Object> objects = strs; // 编译失败
        }
        {
            // 编译成功:要加上强制转换
            List<String> strs = new ArrayList<String>();
            List<Object> objects = (List) strs;
        }

        {
            // 编译成功：:要加上强制转换
            List<String> strs = (List) new ArrayList<Integer>();
            List<Object> objects = (List) strs;
        }
    }
}

class Parent<T> {

    public void setSrc(T src) {

    }
}

class Child extends Parent<String> {
    @Override
    public void setSrc(String src) {
        super.setSrc(src);
    }
}