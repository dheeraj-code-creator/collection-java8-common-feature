package com.example.stringtolistsorting;

import java.util.List;
import java.util.stream.Collectors;

public class StringToList {

    public static void main(String[] args) {

        // convert this string to list and do the sorting
        String str ="10011010";

        // java 7
        /*List<Character> list = new ArrayList<>();
        for(char c: str.toCharArray()){
            list.add(c);
        }
        System.out.println(list);*/

        // java 8
        List<Character> characterList = str.chars().mapToObj(k ->(char)k).collect(Collectors.toList());
        characterList = characterList.stream().sorted().collect(Collectors.toList());
        System.out.println(characterList);

        // java 8 in one line
        List<Character> list = str.chars().mapToObj(k->(char)k).sorted().collect(Collectors.toList());
        System.out.println(characterList);
    }
}
