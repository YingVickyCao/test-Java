package com.example.hades.java._comment;

//: DocTest.java


/**
 * <pre>
 * 一个类注释
 * </pre>
 * <p>
 * <p>
 * <p>
 * 您<em>甚至</em>可以插入一个列表:
 * <ol>
 * <li> 项目一
 * <li> 项目二
 * <li> 项目三
 * </ol>
 */

/**
 * @author ABC@com
 * @author ABC ABC@com
 * @author <a href="mailto:ABC@com">ABC</a>
 * @author <a href="https://www.baidu.com"> www.baidu.com</a>
 * @version 1.0
 */
public class DocTest {
    /**
     * 一个变量注释
     */
    public int i;
    /**
     * 默认数量 {@value}
     */
    private static final Integer QUANTITY = 1;

    /**
     * 一个方法注释
     */
    public void f() {
    }

    /**
     * @param a num1
     * @param b num2
     * @return max of a and b
     * @see Integer
     * @see java.lang.Integer
     * @see java.lang.Integer#getInteger(String)
     * @see <a href="package-summary.html">java.util.stream</a>
     * @since 1.8
     * <code> MAX_VALUE </code>
     */
    public int num(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * @throws Exception
     * @throws Exception
     * @deprecated use num(int,int)
     * {@link java.lang.Character}
     * {@link String}
     * {@link #num(int, int)}
     * {@link java.lang.String#charAt(int)}
     */
    public int num2(int a, int b) throws Exception {
        return a > b ? a : b;
    }
}
//: DocTest.java