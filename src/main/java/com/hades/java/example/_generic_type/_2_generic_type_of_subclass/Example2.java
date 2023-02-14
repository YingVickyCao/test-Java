package com.hades.java.example._generic_type._2_generic_type_of_subclass;

import java.util.ArrayList;
import java.util.List;

public class Example2 {
    public static void main(String[] args) {
        Example2 example2 = new Example2();
        example2.test();
    }

    private void test() {
        List<Apple> apples = new ArrayList<>();
        /**
         * Error : Compile Error.
         * Required type: List <Fruit>
         * Provided: List <Apple>
         */
//        List<Fruit> fruits = apples;
    }
}


class Fruit {

}

class Apple extends Fruit {

}
