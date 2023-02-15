package com.hades.java.example._generic_type;

/**
 * 通配符 ( ? extends 父类)：
 * 表示只能接收父类以及它的子类且接收后只能使用父类中方法。
 */
public class _6_Use_Wildcard_extends {
    public static void main(String[] args) {
        _6_Use_Wildcard_extends example = new _6_Use_Wildcard_extends();
        example.test();
    }

    private void test() {
        BusinessMan<Fruit> v1 = new BusinessMan<>();
        v1.setFruit(new Fruit());
        v1.fruit.name();
        System.out.println();

        BusinessMan<Apple> v2 = new BusinessMan<>();
        v2.setFruit(new Apple());
        v2.fruit.name();
        v2.fruit.amApple();
        System.out.println();

        BusinessMan<Orange> v3 = new BusinessMan<>();
        v3.setFruit(new Orange());
        v3.fruit.name();
        v3.fruit.amOrange();
        System.out.println();

        sale(v1);
        sale(v2);
        sale(v3);
    }

    /*
            Fruit
           /     \
       Apple       Orange
     */

    class Fruit {
        public void name() {
            System.out.println(this.getClass().getSimpleName());
        }
    }

    class Apple extends Fruit {
        public void amApple() {
            System.out.println("I am apple");
        }
    }

    class Orange extends Fruit {
        public void amOrange() {
            System.out.println("I am Orange");
        }
    }

    class BusinessMan<T> {
        private T fruit;

        public void setFruit(T fruit) {
            this.fruit = fruit;
        }

        public T getFruit() {
            return fruit;
        }
    }

    private void sale(BusinessMan<? extends Fruit> businessMan) {
        /**
         * BusinessMan<Orange> 传入后，not able to invoke amOrange()，only can invoke name()
         * BusinessMan<Apple>  传入后，not able to invoke amApple()， only can invoke name()
         *
         */
        businessMan.getFruit().name();
    }
}
