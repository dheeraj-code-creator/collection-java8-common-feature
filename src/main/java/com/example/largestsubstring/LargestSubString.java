package com.example.largestsubstring;

import java.util.*;
import java.util.stream.Collectors;

public class LargestSubString {
    public static void main(String[] args) {
        // remove repeatable character
        // substring
        // largest string
        // find out those character which occurs only once for ex: d,a occurs only once
        // find out total number of each character in a string ex: i=2, n=2, a=1, d=1

        String str = "indian";
        String largestString = "";
        Set<String> set = new HashSet<>();

        // remove repeatable character
        String collect = Arrays.stream(str.split("")).filter(k -> set.add(k)).collect(Collectors.joining());
        System.out.println(collect);

        // substring
        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<str.length(); j++){
                System.out.println(str.substring(i,j));

                // largest string
                if(str.substring(i,j).length()>largestString.length()){
                    largestString = str.substring(i,j);
                }
            }

        }
        System.out.println("largest string = " + largestString);

        // find out those character which occurs only once for ex: d,a occurs only once
        String uniqueCharacter = Arrays.stream(str.split(""))
                .filter(k -> Collections.frequency(Arrays.asList(str.split("")), k) == 1).collect(Collectors.joining());
        System.out.println("unique character = " + uniqueCharacter);

        // find out total number of each character in a string ex: i=2, n=2, a=1, d=1
        Map<String, Long> collect1 = Arrays.stream(str.split("")).collect(Collectors.groupingBy(k -> k, Collectors.counting()));
        System.out.println("total number of occurence = " + collect1.entrySet());


    }
}
