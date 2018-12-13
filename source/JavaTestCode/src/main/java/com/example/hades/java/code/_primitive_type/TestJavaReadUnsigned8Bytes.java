package com.example.hades.java.code._primitive_type;

import com.example.hades.java.code._framework.CollectionUtil;
import com.example.hades.java.code._framework.Log;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

/*
How to read the yte
Request Method:GET
reponse content-type:application/json

Request Method:GET
content-type:application/octet-stream, data = 8 Unsigned Bytes


模拟业务
js 发送一个请求：content-type：application/octet-stream 返回二进制数组（8 bits unsigned byte array，Uint8Array）
，js端收到请求后，解析数据，把得到点unsigned byte array =》 ，变成Uint8Array。

题目是：
将上述操作转换成java：
java 发送一个请求：content-type：application/octet-stream 返回二进制数组，
，java端收到请求后，解析数据，得到short 数组或者int 数组。

注意：
8 bits unsigned byte array，Uint8Array中byte的数值范围为0～255
java中byte 为 signed byte，数值范围为-128～127.
 */
public class TestJavaReadUnsigned8Bytes {
    private static final String TAG = TestJavaReadUnsigned8Bytes.class.getSimpleName();

    private static final String RELATIVE_PATH_FILE_NAME = "src/main/resources/com/example/hades/java/code/download";

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //read8BitesUnsignedBytes_by_int(); // error
        read8BitesUnsignedBytes_by_byte(); // ok
        //read8BitesUnsignedBytes_by_StringList();  // error

        testIsUnsignedByte128();
    }

    /**
     * File content is 8 bites unsigned byte
     * [246, 254, 255, 0, 10, 126, 127, 128, 129, 253, 254, 255, 0, 1, 232]
     */
    /**
     * origin = 65533,  converted = 253
     * origin = 65533,  converted = 253
     * origin = 65533,  converted = 253
     * origin = 0,  converted = 0
     * origin = 10,  converted = 10
     * origin = 126,  converted = 126
     * origin = 127,  converted = 127
     * origin = 65533,  converted = 253
     * origin = 65533,  converted = 253
     * origin = 65533,  converted = 253
     * origin = 65533,  converted = 253
     * origin = 65533,  converted = 253
     * origin = 0,  converted = 07
     * origin = 1,  converted = 1
     * origin = 65533,  converted = 253
     */

    /**
     * Solution: ERROR
     * JavaScript - Saved by 8  bites unsigned byte.
     * JAVA       - Read  by 32 bites signed int -> short or int.
     */
    static void read8BitesUnsignedBytes_by_int() {
        System.out.println("read8BitesUnsignedBytes_by_int,start");
        FileInputStream fis = null;
        InputStreamReader isr = null;
        Reader in = null;
        try {
            fis = new FileInputStream(RELATIVE_PATH_FILE_NAME);
            isr = new InputStreamReader(fis, "UTF8");
            in = new BufferedReader(isr);
            int origin;
            while ((origin = in.read()) > -1) {
                // buffer.append((char)ch);
                int converted = 0xFF & origin;
                System.out.print("origin = " + origin + ",  converted = " + converted);
                System.out.println();
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fis) {
                    fis.close();
                }
                if (null != isr) {
                    isr.close();
                }
                if (null != in) {
                    in.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("read8BitesUnsignedBytes_by_int,end");
    }

    /**
     * File content is 8 bites unsigned byte
     * [246, 254, 255, 0, 10, 126, 127, 128, 129, 253, 254, 255, 0, 1, 232]
     */
    /*
     read8BitesUnsignedBytes_by_byte,start
     origin,afterTransValue -10, 246
     -2, 254
     -1, 255
     0,   0
     10,  10
     126, 126
     127, 127
     -128, 128
     -127, 129
     -3, 253
     -2, 254
     -1, 255
     0,   0
     1,   1
     -24, 232
     read8BitesUnsignedBytes_by_byte,end
     */
    /**
     * JavaScript - Saved by 8 bites unsigned byte.
     * JAVA       - Read  by 8 bites signed byte -> short or int.
     */
    /**
     * Solution: Right
     */
    static void read8BitesUnsignedBytes_by_byte() {
        System.out.println("read8BitesUnsignedBytes_by_byte,start");

        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get(RELATIVE_PATH_FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (null == bytes) {
                return;

            }

            System.out.print("origin,afterTransValue");
            for (int i = 0; i < bytes.length; i++) {
                /**
                 * First, read as the 8 bites signed byte.
                 * Second, get the signed tag as the value.
                 */
                byte origin = bytes[i];
                //int afterTransValue = 0xFF & origin;
                short afterTransValue = (short) (0xFF & origin);
//                System.out.println(bytes[i] + "," + afterTransValue);
                System.out.println(String.format("%4d", bytes[i], Locale.US) + "," + String.format("%4d", afterTransValue, Locale.US));
            }
        }
        System.out.println("read8BitesUnsignedBytes_by_byte,end");
    }

    /**
     * Solution: ERROR
     */
    static void read8BitesUnsignedBytes_by_StringList() {
        System.out.println("read8BitesUnsignedBytes_by_StringList,start");

        List<String> list = null;
        try {
            // ERROR- java.nio.charset.MalformedInputException: Input length = 1
            list = Files.readAllLines(Paths.get(RELATIVE_PATH_FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null == list || list.isEmpty()) {
                return;
            }

            for (int i = 0; i < list.size(); i++) {
                String item = list.get(i);
                System.out.print("item=" + item);
                System.out.println();
            }
        }
        System.out.println("read8BitesUnsignedBytes_by_StringList,end");
    }

    // 0,127,128,200,254,255,256

    /**
     * sampleBytes=0,127,128,200,254,255,0
     * byteValue=0,result1=0,result2=false
     * byteValue=127,result1=0,result2=false
     * byteValue=128,result1=128,result2=true
     * byteValue=200,result1=128,result2=true
     * byteValue=254,result1=128,result2=true
     * byteValue=255,result1=128,result2=true
     * byteValue=0,result1=0,result2=false
     **/
    public static void testIsUnsignedByte128() {
        short[] sampleBytes = new short[7];
        sampleBytes[0] = 0;
        sampleBytes[1] = 127;
        sampleBytes[2] = 128;
        sampleBytes[3] = 200;
        sampleBytes[4] = 254;
        sampleBytes[5] = 255;
        //sampleBytes[6] = 256;
        Log.d(TAG, "testIsUnsignedByte128", "sampleBytes=" + sampleBytes.toString(), true);

        StringBuffer stringBuffer = CollectionUtil.buildArray2String(sampleBytes);
        Log.d(TAG, "testIsUnsignedByte128", "sampleBytes=" + stringBuffer, true);

        for (int i = 0; i < sampleBytes.length; i++) {
            isUnsignedByte128(sampleBytes[i]);
        }
    }


    private static void isUnsignedByte128(short byteValue) {
        short result1 = (short) (byteValue & 0x80);
        boolean result2 = ((byteValue & 0x80) == 128);
        Log.d(TAG, "isUnsignedByte128", "byteValue=" + byteValue + ",result1=" + result1 + ",result2=" + result2, true);
    }
}