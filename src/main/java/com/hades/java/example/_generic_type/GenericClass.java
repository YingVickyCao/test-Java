package com.hades.java.example._generic_type;

/**
 * 范型类
 */
public class GenericClass {
    public static void main(String[] args) {
        {
            // 能卖任何水果
            BusinessMan businessMan = new BusinessMan();
            businessMan.sales(new Apple());
            businessMan.sales(new Banana());
        }

        {
            // 只能卖苹果
            BusinessMan<Apple> businessMan = new BusinessMan();
            businessMan.sales(new Apple());
        }

        {
            // 范型方法
            BusinessMan<Apple> businessMan = new BusinessMan();
            businessMan.method("This is a string");
            BusinessMan.method2("This is a string");
        }

        {

        }
    }
}

//class BusinessMan {
//    public void sales(Apple fruit) {
//        System.out.println("sail " + fruit.getClass().getSimpleName());
//    }
//
//    public void sales(Banana fruit) {
//        System.out.println("sail " + fruit.getClass().getSimpleName());
//    }
//}
//
//class Apple {
//
//}
//
//class Banana {
//
//}

/**
 * BusinessMan 是一个范型类
 */
class BusinessMan<T> {

    public void sales(T fruit) {
        System.out.println("sail " + fruit.getClass().getSimpleName());

        // Error: Compile Error，因为不能在编译时确定它的类型，因此不能用范型T来new 一个对象。
        // new T();
    }

    // Error: Compile Error，范型类的普通方法不能是static。因为编译时T的类型是不能确定的，只能在运行时才能确定，因此，sales2不能是static。
//    public static void sales2(T fruit) {
//        System.out.println("sail " + fruit.getClass().getSimpleName());
//    }

    /**
     * 范型方法
     */
    public <M> void method(M m) {
        System.out.println(m);
    }

    /**
     * 范型方法
     * 范型方法可以是static
     */
    public static <M> void method2(M m) {
        System.out.println(m);
    }
}

class Apple {

}

class Banana {

}

/**
 * FruitBusinessMan 是一个范型类
 * 父类是范型类，那么子类也是范型类。指定的范型只能多，不能少。
 */
class FruitBusinessMan<T, E> extends BusinessMan<T> {
    public void sales(T t, E e) {
        System.out.println();
    }
}