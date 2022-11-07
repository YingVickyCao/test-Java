package com.hades.java.test.string;

import java.util.Date;
import java.util.Locale;

/**
 * <a href=https://gitee.com/YingVickyCao/YingVickyCao.github.io/blob/master/tech/java/String/String.md>String.md</a>
 * <a href=https://www.cnblogs.com/zengming/p/9674972.html>blog of JAVA字符串格式化-String.format()的使用</a>
 */
public class StringFormatExample {
    public static void main(String[] args) {
        StringFormatExample example = new StringFormatExample();
        example.formatString_for_data_type();
        example.formatString_2();
        example.formatString_for_Date();
        example.formatString_for_time();
    }

    // 格式化不同数据类型到字符串
    private void formatString_for_data_type() {
        // %s : 字符串
        System.out.println(String.format("Hi,%s, today is %s", "Vicky", "Tuesday"));    // Hi,Vicky, today is Tuesday
        // %c : 字符
        System.out.println(String.format("x%cz", 'y'));  // xyz
        // %b : 布尔
        System.out.println(String.format("result is %b", (3 > 7)));   // result is false

        System.out.println(String.format("整数十进制 is %d", 100));   // 100
        System.out.println(String.format("整数100的十六进制 is %x", 100));   // 64
        System.out.println(String.format("整数100的八进制 is %o", 100));   // 144


        System.out.println(String.format("浮点数 %f", 1.62));   // 1.620000
        System.out.println(String.format("十六进制浮点数 %a", 1.62));   // 0x1.9eb851eb851ecp0
        System.out.println(String.format("指数类型 %e", 1.62));   // 1.620000e+00
        System.out.println(String.format("通用浮点类型 %g", 1.62));   // 1.62000

        // TODO: 12/21/21 散列码
        System.out.println();
        System.out.println(String.format("散列码 %h", 'a'));   // 61
        System.out.println(String.format("散列码 %h", 'A'));   // 41
        System.out.println(String.format("散列码 %h", 10));   // a
        System.out.println(String.format("散列码 %H", 'a'));   // 61
        System.out.println(String.format("散列码 %H", 'A'));   // 41
        System.out.println(String.format("散列码 %H", 10));   // A
        int num = 'A';
        System.out.println(num);    // 65
        System.out.println(Character.hashCode('A'));    // 65
        System.out.println("A".hashCode());  // 65
        System.out.println(String.format("散列码 %H", "abc"));   // 17862
        System.out.println();

        System.out.println(String.format("百分比 %%", ""));   // %
        System.out.println(String.format("百分比 %d%%", 99));   // 99%

        System.out.println(String.format("日期与时间类型 %d%%", 99));   // 99%
    }

    // 搭配转换符的标志
    private void formatString_2() {
        // %+:正数或负数符号
        System.out.println(String.format("%+d", 99));   // +99
        System.out.println(String.format("%+d", -99));  // -99

        // %-N:左对齐
        System.out.println(String.format("%-5d", 123)); // 5位，向左对齐
        // %N:右对齐
        System.out.println(String.format("%5d", 123));  // 5位，向右对齐。数字前补空格
        System.out.println(String.format("%05d", 123)); // 5位，向右对齐。数字前补0
        System.out.println(String.format("% 5d", 123)); // 5位，向右对齐。数字前补空格

        // %, : 使用,对数字分组
        System.out.println(String.format("%,d", 12345678)); // 12,345,678

        // %( : 使用括号包含负数
        System.out.println(String.format("%(d", -12)); // (12)
        System.out.println(String.format("%(d", 25)); // 25

        // %# : 16进制或8进制添加前缀0x或0
        System.out.println(String.format("%#x", 4)); // 0x4
        System.out.println(String.format("%#o", 4)); // 04

        // %< : 格式化前一个转换符所描述的参数
        // .3表示小数点后输出3位
        System.out.println(String.format("%f,转换后：%<.3f %n", 3.14159265)); // 3.141593,转换后：3.142

        // %N$d : 指定被格式化的参数索引
        System.out.println(String.format("%1$d,%2$s", 12, "abc", "xyz"));   // 12,abc
        System.out.println(String.format("%1$d,%3$s", 12, "abc", "xyz"));   // 12,xyz
    }

    // 格式化日期到字符串
    private void formatString_for_Date() {
//        Date date = new Date();
//        System.out.println(date.getTime()); // 1640072573407

        Date date = new Date(1640072573407L);
        System.out.println(date);                                                           // Tue Dec 21 15:42:53 CST 2021

        // %tc : 包括全部的日期和时间格式
        // Locale:en_CN     当前程序的JVM默认值 language_region
        System.out.println(String.format("%tc", date));                                     // Tue Dec 21 15:42:53 CST 2021
        // Locale:zh_CN
        System.out.println(String.format(Locale.SIMPLIFIED_CHINESE, "%tc", date));  // 星期二 十二月 21 15:42:53 CST 2021
        // Locale:en_US
        System.out.println(String.format(Locale.US, "%tc", date));                  // Tue Dec 21 15:42:53 CST 2021

        // %tF : 年-月-日格式
        System.out.println(String.format("%tF", date));  // 2021-12-21


        // %tD : 月/日/年格式
        System.out.println(String.format("%tD", date));  // 12/21/21

        // TODO: 12/21/21
//        System.out.println(String.format("%td",date));  // 21

        // %tr : HH:MM:SS PM格式（12时制)
        System.out.println(String.format("%tr", date)); // 03:42:53 PM

        // %tT : HH:MM:SS PM格式（24时制)
        System.out.println(String.format("%tT", date)); // 15:42:53

        // %tb : 月份
        System.out.println(String.format("%tb", date)); // Dec
        System.out.println(String.format(Locale.SIMPLIFIED_CHINESE, "%tb", date)); // 十二月

        // %tB : 月份
        System.out.println(String.format("%tB", date)); // December

        // %ta : 日期缩写
        System.out.println(String.format("%ta", date)); // Tue

        // %tA : 日期全称
        System.out.println(String.format("%tA", date)); // Tuesday
        System.out.println(String.format(Locale.SIMPLIFIED_CHINESE, "%tA", date)); // 星期二

        // %tC : 年的前两位。不足两位前面补0
        System.out.println(String.format("%tC", date)); // 20

        // %ty : 年的前后位。不足两位前面补0
        System.out.println(String.format("%ty", date)); // 21

        // %tj : 年的第几天
        System.out.println(String.format("%tj", date)); // 355

        // %tm : 月份。不足两位前面补0
        System.out.println(String.format("%tm", date)); // 12

        // %td : 月的第几天（两位，不足两位前面补0）
        System.out.println(String.format("%td", date)); // 21

        // %td : 月的第几天（1位，不补零）
        System.out.println(String.format("%te", date)); // 21

    }

    // 格式化时间到字符串
    private void formatString_for_time() {
//        Date date = new Date();
//        System.out.println(date.getTime()); // 1640072573407

        Date date = new Date(1640072573407L);
        System.out.println(date);                       // Tue Dec 21 15:42:53 CST 2021

        // %tH : 小时（24时制；两位，不足两位前面补0）
        System.out.println(String.format("%tH", date)); // 15

        // %tk : 小时（24时制；两位，不足两位前面不补0）
        System.out.println(String.format("%tk", date)); // 15

        // %tI : 小时（12时制；两位，不足两位前面补0）
        System.out.println(String.format("%tI", date)); // 03

        // %tl : 小时（12时制；两位，不足两位前面不补0）
        System.out.println(String.format("%tl", date)); // 3

        // %tM : 分钟（两位，不足两位前面不补0）
        System.out.println(String.format("%tM", date)); // 42

        // %tS : 秒（两位，不足两位前面不补0）
        System.out.println(String.format("%tS", date)); // 53

        // %tL : 豪秒（三位，不足三位前面不补0）
        System.out.println(String.format("%tL", date)); // 407

        // %tL : 9位数字的毫秒数（不足9位前面补0）
        System.out.println(String.format("%tN", date)); // 407000000

        // %tp : 用小写字母标记上午或下午
        System.out.println(String.format("%tp", date)); // pm

        // %tz : 时区偏移量
        System.out.println(String.format("%tz", date)); // +0800

        // %tZ : 时区缩写字母
        System.out.println(String.format("%tZ", date)); // CST

        // %ts : 1970-1-1 00:00:00 到现在所经过的秒数
        System.out.println(String.format("%ts", date)); // 1640072573

        // %tQ : 1970-1-1 00:00:00 到现在所经过的毫秒数，也就是常说的与时区无关的时间戳
        System.out.println(String.format("%tQ", date)); // 1640072573407
    }
}