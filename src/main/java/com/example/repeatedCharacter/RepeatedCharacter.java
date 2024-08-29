package com.example.repeatedCharacter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RepeatedCharacter {
    public static void main(String[] args) {

        // java 7
        String str = "india";
        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<str.length(); j++){
                if(str.charAt(i)==str.charAt(j)){
                    System.out.println( "repeated string is: " + str.charAt(j));
                }
            }
        }

        System.out.println("############################");

        // java 8
        Set<Character> set = new HashSet<>();
        str.chars().mapToObj(c->(char)c).filter(k-> !set.add(k)).collect(Collectors.toSet())
                .forEach(System.out::println);

    }
}
