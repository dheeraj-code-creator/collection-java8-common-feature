package com.example.java8feature;

import java.util.Arrays;
import java.util.List;

/*
Stream provides functional style operations, it doesn't modify actual source of data.
it creates a parallel stream and performs the opearations.

Functional programming or Declarative programing
        Used in-built function, transfer data from one function to another function.
        example: stream().filter(number -> number % 2 == 0).mapToInt(e -> e * 2)

Object oriented progra or Imperative programing
        writes actual implementation code,
        example: int result = 0;
                  for (Integer n : numbers) {
                    if (n % 2 == 0) {
                      result += n * 2;
                    }
                  }
*/
public class StreamExample {
    public static void main(String[] args) {
        List<String> nameList = Arrays.asList("Dheeraj", "Surbhi", "Banti");
        nameList.stream().filter(k->k.startsWith("D")).forEach(a->System.out.println(a));

        // method reference
        nameList.stream().filter(k->k.startsWith("D")).forEach(System.out::println);
    }
}
