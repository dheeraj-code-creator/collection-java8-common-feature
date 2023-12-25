package com.example.java8feature;

import java.util.function.Function;

/*Function is a functional interface which takes two arguments<T, R> perform operation and convert one type to
  another type as a output.
  its method is apply()
<T = type of input
 R = type of result >*/

public class FunctionExample {

    public static void main(String[] args) {
        String name = "dheeraj";
        Function<String, Integer> f = k -> name.length();
        System.out.println(f.apply(name));
    }
}
