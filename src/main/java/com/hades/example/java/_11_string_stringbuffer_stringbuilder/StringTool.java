package com.hades.example.java._11_string_stringbuffer_stringbuilder;

import java.util.Arrays;

public class StringTool {
    private static volatile StringTool mInstance;

    public static StringTool getInstance() {
        if (null == mInstance) {
            synchronized (StringTool.class) {
                if (null == mInstance) {
                    mInstance = new StringTool();
                }
            }
        }
        return mInstance;
    }

    public String[] spiltStringByStep(String s, final int step) {
        final int spiltNum = (s.length()) / step;
        String[] dest;
        if ((s.length() % step) > 0) {
            dest = new String[spiltNum + 1];
        } else {
            dest = new String[spiltNum];
        }
        if (spiltNum > 0) {

            int start = 0;
            for (int i = 0; i < dest.length; i++) {
                if (i == 0) {
                    dest[0] = s.substring(start, step);
                    start = step;
                } else if (i < dest.length - 1) {
                    dest[i] = s.substring(start, start + step);
                    start = start + step;
                } else {
                    dest[i] = s.substring(start);
                }
            }
        }
        System.out.println(Arrays.toString(dest));
        return dest;
    }

}
