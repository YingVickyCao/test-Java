package com.hades.java.example._generic_type;

import java.util.ArrayList;
import java.util.List;

public class _2_Generic_Type_of_Subclass {
    public static void main(String[] args) {
        _2_Generic_Type_of_Subclass example2 = new _2_Generic_Type_of_Subclass();
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

    class Fruit {

    }

    class Apple extends Fruit {

    }
}
