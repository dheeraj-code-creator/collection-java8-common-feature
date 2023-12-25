package com.example.java8feature;

import java.util.Locale;
import java.util.function.Consumer;

/*Consumer is a functional interface which takes an argument performs the operation but doesn't return anything
its method is accept()*/

public class ConsumerExample {

    public static void main(String[] args) {

        Consumer<String> c = a -> System.out.println(a.toUpperCase());
        c.accept("dheeraj");

    }
}
