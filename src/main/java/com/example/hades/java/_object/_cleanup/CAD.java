package com.example.hades.java._object._cleanup;

public class CAD extends Shape {
    private static final String TAG = CAD.class.getSimpleName();
    private Circle shape1;
    private Line shape2;

    CAD(int size) {
        super(size);
        System.out.println(TAG + " Constructor ---------->");
        System.out.println();

        shape1 = new Circle(size);

        shape2 = new Line(size);
        System.out.println(TAG + " Constructor <----------");
        System.out.println();
    }

    void clean() {
        System.out.println(TAG + " clean() ==========>");
        shape2.clean();
        shape1.clean();
        super.clean();
        System.out.println(TAG + " clean() <==========");
    }


    public static void main(String[] args) {
        CAD cad = new CAD(5);
        try {
            //
        }
//        catch (Exception ex){
//
//        }
        finally {
            cad.clean();
        }
    }
}