package com.example.hades.java.code._collection.stack;

import com.example.hades.java.code._framework.Log;

import java.util.Stack;

public class StringCache {
    private static final String TAG = StringCache.class.getSimpleName();

    private Stack<String> mStack = new Stack<>();
    private static StringCache mInstance = null;

    public static StringCache getInstance() {
        if (null == mInstance) {
            mInstance = new StringCache();
        }
        return mInstance;
    }

    public void addString(String s) {
        if (null == s) {
            return;
        }
        mStack.push(s);
        Log.d(TAG, "addString: s=" + s);
    }

    public String getCurrentString() {
        if (isEmpty()) {
            return null;
        }
        String s = mStack.peek(); // 只查找最top，不出栈
        Log.d(TAG, "getCurrentString: s=" + s);
        return s;
    }

    public void removeCurrentString() {
        if (isEmpty()) {
            return;
        }
        String s = mStack.pop();
        Log.d(TAG, "removeCurrentString: s=" + s);
    }

    public void removeString(String s) {
        if (isEmpty() || null == s) {
            return;
        }
        Log.d(TAG, "removeString: s=" + s);
        mStack.remove(s);
    }

    public boolean isEmpty() {
        return null == mStack || mStack.isEmpty();
    }
}
