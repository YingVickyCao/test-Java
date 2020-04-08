package com.hades.example.java._object._overload._tostring;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class Base implements Serializable {
    private static final long serialVersionUID = 402154372800404254L;

    @Override
    public String toString() {
        /**
         * 方法1：
         * https://blog.csdn.net/qq_21383435/article/details/79569665
         * 实现方式：反射机制。
         *          通过reflection包中的AccessibleObject类，绕过访问控制而直接存取对象的私有成员。注意运行环境的安全策略是否支持
         * 好处：避免toString()时暴内存
         * 依赖：
         *     compile group: 'commons-lang', name: 'commons-lang', version: '2.6'
         *      /
         *      compile group: 'org.apache.commons', name: 'commons-lang3', version: '3.10'
         */
        return ToStringBuilder.reflectionToString(this);
    }
}

