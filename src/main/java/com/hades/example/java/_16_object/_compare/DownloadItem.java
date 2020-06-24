package com.hades.example.java._16_object._compare;

public class DownloadItem implements Comparable {
    boolean isSaved;
    int num;
    String name;

    public DownloadItem(boolean isSaved, int num, String name) {
        this.isSaved = isSaved;
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString() {
        return "DownloadItem{" +
                "isSaved=" + isSaved +
                ", num=" + num +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * @param o the object to be compared.
     * @return 0 this object is equal to this
     * -1 this object s less than this
     * 1 this object s greater than this
     */
    @Override
    public int compareTo(Object o) {
        /**
         * ASC
         */
        if (!(o instanceof DownloadItem)) {
            return 0;
        }
        // this= Second one
        // o = First one
        DownloadItem bean = (DownloadItem) o;
        if (this.isSaved && !bean.isSaved) {
            return 1;
        }
        if (!this.isSaved && bean.isSaved) {
            return -1;
        }
        return Integer.compare(this.num, bean.num);
        //        return this.name.compareTo(bean.name);
    }
}
