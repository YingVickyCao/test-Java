package com.hades.example.java._array._varargs;

public class OverloadingVarargs2 {
    /**
     * Error:(6, 9) java: reference to f is ambiguous
     * both method f(float,Character...) in OverloadingVarargs2 and method f(Character...) in OverloadingVarargs2 match
     */
    public static void main(String[] args) {
        f(1, 'a');
        f('b', '2');
    }

    // 编译器不知道调用哪个方法？增加一个非可变参数
//    public static void f(float i, Character... args) {
//        System.out.print("Second: ");
//        for (Character item : args) {
//            System.out.print(item + "  ");
//        }
//        System.out.println();
//    }
//
//    public static void f(Character... args) {
//        System.out.print("Second: ");
//        for (Character item : args) {
//            System.out.print(item + "  ");
//        }
//        System.out.println();
//    }


    public static void f(float i, Character... args) {
        System.out.print("Second: ");
        for (Character item : args) {
            System.out.print(item + "  ");
        }
        System.out.println();
    }

    public static void f(char ch, Character... args) {
        System.out.print("Second: ");
        for (Character item : args) {
            System.out.print(item + "  ");
        }
        System.out.println();
    }
}
