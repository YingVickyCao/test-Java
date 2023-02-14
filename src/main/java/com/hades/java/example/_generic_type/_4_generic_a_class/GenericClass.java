package com.hades.java.example._generic_type._4_generic_a_class;

/**
 * 泛型类
 */
public class GenericClass {
    public static void main(String[] args) {
        GenericClass example = new GenericClass();
        example.test();
    }

    private void test() {
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
            // 泛型方法
            BusinessMan<Apple> businessMan = new BusinessMan();
            businessMan.method("This is a string");
            BusinessMan.method2("This is a string");
        }


        {
            // 只能卖苹果
            FruitBusinessMan<Apple, String> businessMan = new FruitBusinessMan<>();
            // 使用环保袋
            businessMan.sales(new Apple(), "环保袋");
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
 * BusinessMan 是一个泛型类
 */
class BusinessMan<T> {

    /**
     * @param fruit 卖的水果
     */
    public void sales(T fruit) {
        System.out.println("sail " + fruit.getClass().getSimpleName());

        // Error: Compile Error，因为不能在编译时确定它的类型，因此不能用泛型T来new 一个对象。
        // new T();
    }

    /**
     * Error: Compile Error，泛型类的static普通方法中不可以使用泛型。因为编译时T的类型是不能确定的，只能在运行时才能确定，因此，sales2不能是static。
     * 总结：
     * 一个泛型类中，它的普通方法-static，不能使用泛型。
     * 一个泛型类中，它的普通方法-非static，能使用泛型。
     * 一个静态方法想要使用泛型，那么该方法要定义成泛型方法。
     */
//    public static void sales2(T fruit) {
//        System.out.println("sail " + fruit.getClass().getSimpleName());
//    }

    /**
     * 泛型方法。它不是一个普通方法。
     */
    public <M> void method(M m) {
        System.out.println(m);
    }

    /**
     * 泛型方法。它不是一个普通方法。
     * 泛型方法可以是static
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
 * FruitBusinessMan 是一个泛型类
 * 父类是泛型类，那么子类也是泛型类。指定的泛型只能多，不能少。
 */
class FruitBusinessMan<T, E> extends BusinessMan<T> {
    /**
     * @param t 卖的水果
     * @param e 使用的袋子类型
     */
    public void sales(T t, E e) {
        System.out.println("卖" + t.getClass().getSimpleName() + "并使用" + e);
    }
}