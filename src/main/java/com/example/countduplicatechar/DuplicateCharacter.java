package com.example.countduplicatechar;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateCharacter {

    public static void main(String[] args) {
        String input = "hjktrhkhftr";

        Map<String, Long> collect = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(k -> k, Collectors.counting()));
        collect.entrySet().forEach(System.out::println);

    }
}
