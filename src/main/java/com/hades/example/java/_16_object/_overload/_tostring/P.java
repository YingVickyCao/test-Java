package com.hades.example.java._16_object._overload._tostring;

import java.util.List;

//public class P {
public class P extends Base {
    private boolean flag;
    private List<String> mNames;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<String> getNames() {
        return mNames;
    }

    public void setNames(List<String> names) {
        mNames = names;
    }

//    @Override
//    public String toString() {
//        StringBuffer sb = new StringBuffer();
//        sb.append("{flag=").append(flag)
//                .append(", mNames=").append(null != mNames ? mNames.toString() : "null")
//                .append("}");
//        return sb.toString();
//    }
}
