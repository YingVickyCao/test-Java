package com.hades.example.java.effective;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        LocalDate date = LocalDate.of(2025,9,19);
        float day = date.getDayOfYear(); // 262
        int day2 = (int) (day / 365  * 5);
        System.out.println(day2);
        double money = 3 * day2 * 30000 / 21.75;
        System.out.println(money);
    }
}