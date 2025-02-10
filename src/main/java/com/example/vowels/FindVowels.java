package com.example.vowels;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindVowels {

    public static void main(String[] args) {

        // find the vowels from the string
        String str = "IceCreAm";

        List<String> vowels = Arrays.stream(str.split("")).filter(k -> "AEIOUaeiou".contains(k)).collect(Collectors.toList());
        System.out.println("vowels are: " + vowels);


        // replace I with A
        // output AceCreaIm
        String replacement = Arrays.stream(str.split("")).map(k -> {
            if (k.equals("I")) {
                return "A";
            } else if (k.equals("A")) {
                return "I";
            } else {
                return k;
            }
        }).collect(Collectors.joining());
        System.out.println("Replacement of string: " + replacement);

    }
}
