package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Object[] object = {"String", 1, 1.0, true};
        Arrays.stream(object).map(ob -> ob.getClass().getName()).forEach(System.out::println);
    }
}