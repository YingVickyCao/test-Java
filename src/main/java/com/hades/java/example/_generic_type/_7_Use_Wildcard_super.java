package com.hades.java.example._generic_type;

public class _7_Use_Wildcard_super {
    public static void main(String[] args) {
        _7_Use_Wildcard_super example = new _7_Use_Wildcard_super();
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

        BusinessMan<SmallOrange> v4 = new BusinessMan<>();
        v4.setFruit(new SmallOrange());
        v4.fruit.name();
        v4.fruit.amOrange();
        v4.fruit.amSmallOrange();
        System.out.println();

        sale(v1);
        sale(v2);
        sale(v3);
        sale(v4);
    }

    /*
                Fruit
               /     \
           Apple     Orange
                        |
                     SmallOrange

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


    class SmallOrange extends Orange {
        public void amSmallOrange() {
            System.out.println("I am SmallOrange");
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

    private void sale(BusinessMan<? super Orange> businessMan) {
        /**
         * BusinessMan<Orange> 传入后，not able to invoke amOrange()，only can invoke name()
         * BusinessMan<Apple>  传入后，not able to invoke amApple()， only can invoke name()
         *
         */
        businessMan.getFruit();
    }
}
