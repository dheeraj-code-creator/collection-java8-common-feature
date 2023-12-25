package com.example.java8feature;

import java.util.function.Predicate;

/*Predicate is a functional interface which takes an argument and return a boolean value
its method is test()*/

public class PredicateExample {

    public static void main(String[] args) {
        int num =20;
        Predicate<Integer> p = a -> num>10;
        System.out.println(p.test(num));

    }
}
