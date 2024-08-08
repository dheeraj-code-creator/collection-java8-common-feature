package com.example.java8feature;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortingInAlphabeticalOrder {

    public static void main(String[] args) {
        List<String> divison = Arrays.asList(
                "Footwear,Apparel",
                "Footwear",
                "Accessories",
                "Apparel,Accessories",
                "Apparel,Footwear",
                "Accessories,Apparel",
                "Apparel",
                "Footwear,Accessories",
                "Accessories,Footwear");

        divison.stream().distinct().sorted().forEach(System.out::println);
    }
}
