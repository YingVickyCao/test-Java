package com.example.hades.java.code._object._finalize;

public class Book extends BaseBook {
    private boolean mIsCheckedIn = true;

    public Book(boolean isCheckedIn) {
        this.mIsCheckedIn = isCheckedIn;
    }

    protected void cleanUp() {
        checkIn();
        releaseNativeResource();
    }

    private void checkIn() {
        mIsCheckedIn = false;
    }

    private void releaseNativeResource() {
    }

    @Override
    protected void finalize() throws Throwable {
        if (!mIsCheckedIn) {
            cleanUp();
            System.out.println("error: check out");
        }
        super.finalize();
    }

    public static void main(String[] args) {
        Book book1 = new Book(false);
        book1.cleanUp();

        /**
         * 终结条件：Book在被垃圾回收前都应该被签入(check in)。由于程序员的错误，有一本书没有被签入
         */
        Book book2 = new Book(false);// Drop reference, forget to clean up
        System.gc();
    }
}
