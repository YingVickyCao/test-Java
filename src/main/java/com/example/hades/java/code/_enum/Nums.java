package com.example.hades.java.code._enum;

/*
    cd src/main/java/
    javac com/example/hades/java/code/_enum/Nums.java
    javap    com/example/hades/java/code/_enum/Nums.class > com/example/hades/java/code/_enum/Nums.txt
    javap -c com/example/hades/java/code/_enum/Nums.class > com/example/hades/java/code/_enum/Nums2.txt
    javap -v com/example/hades/java/code/_enum/Nums.class > com/example/hades/java/code/_enum/Nums3.txt
 */
public enum Nums {
    ONE, TWO, THREE

    /*
    ONE(1), TWO(22), THREE(33){
        @Override
        public int getValue() {
            return 33;
        }
    };

    int value;

    Nums(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }*/
}