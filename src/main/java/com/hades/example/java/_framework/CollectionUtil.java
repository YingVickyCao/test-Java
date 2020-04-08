package com.hades.example.java._framework;

/**
 * Created by yc99656 on 06/07/2017.
 */
public class CollectionUtil {
    private static final String TAG = CollectionUtil.class.getSimpleName();

    public static StringBuffer buildArray2String(short[] sampleBytes) {
        StringBuffer stringBuffer = new StringBuffer();
        if (null == sampleBytes) {
            stringBuffer.append("null");
            return stringBuffer;
        }

        stringBuffer.append("[");
        for (int i = 0; i < sampleBytes.length; i++) {
            stringBuffer.append(sampleBytes[i]);
            if (i != sampleBytes.length - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("]");
        return stringBuffer;
    }

    public static StringBuffer buildArray2String(int[] sampleBytes) {
        StringBuffer stringBuffer = new StringBuffer();
        if (null == sampleBytes) {
            stringBuffer.append("null");
            return stringBuffer;
        }

        stringBuffer.append("[");
        for (int i = 0; i < sampleBytes.length; i++) {
            stringBuffer.append(sampleBytes[i]);
            if (i != sampleBytes.length - 1) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("]");
        return stringBuffer;
    }
}
