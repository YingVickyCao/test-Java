package com.example.hades.java.code._object._initial_value._static_data;

public class TestStaticInitialization {
    public static class Bowl {
        Bowl(int marker) {
            System.out.println("Bowl(" + marker + ")");
        }

        void f1(int n) {
            System.out.println("f1(" + n + ")");
        }
    }

    static class Table {
        static Bowl bowl1 = new Bowl(1);

        public Table() {
            System.out.println("Table()");
            bowl1.f1(1);
        }

        void f2(int n) {
            System.out.println("f2(" + n + ")");
        }

        static Bowl bowl2 = new Bowl(2);
    }

    static class Cupboard {
        Bowl bowl3 = new Bowl(3);
        static Bowl bowl4 = new Bowl(4);

        Cupboard() {
            System.out.println("Cupboard()");
            bowl4.f1(2);
        }

        void f3(int n) {
            System.out.println("f3(" + n + ")");
        }

        static Bowl bowl5 = new Bowl(5);
    }

    /*
        Bowl(1)
        Bowl(2)
        Table()
        f1(1)
        Bowl(4)
        Bowl(5)
        Bowl(3)
        Cupboard()
        f1(2)
        ----new Cupboard() 1-->
        Bowl(3)
        Cupboard()
        f1(2)
        <----new Cupboard() 1--
        ----new Cupboard() 2-->
        Bowl(3)
        Cupboard()
        f1(2)
        <----new Cupboard() 2-->
        f2(1)
        f3(1)
     */
    public static void main(String args[]) {
        System.out.println("----new Cupboard() 1-->");
        new Cupboard();
        System.out.println("<----new Cupboard() 1--");

        System.out.println("----new Cupboard() 2-->");
        new Cupboard();
        System.out.println("<----new Cupboard() 2-->");

        table.f2(1);
        cupboard.f3(1);
    }

    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}