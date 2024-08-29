package com.example.anagram;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class AnagramTest {

    public static void main(String[] args) {
        String str1 = "KEEP";
        String str2 = "PEEK";
        boolean flag = true;

        // without using StringBuffer reverse() function
        if(str1.length()!=str2.length()){
            flag = false;
        }else{
            char[] charArrayStr1 = str1.toLowerCase().toCharArray();
            char[] charArrayStr2 = str2.toLowerCase().toCharArray();
            Arrays.sort(charArrayStr1);
            Arrays.sort(charArrayStr2);
            flag = Arrays.equals(charArrayStr1, charArrayStr2);
        }
        if(flag){
            System.out.println("Str1 and Str2 both are Anagram");
        }else{
            System.out.println("Str1 and Str2 are Not Anagram");
        }

        // Java 8
        boolean equals = Arrays.stream(str1.split("")).sorted().collect(Collectors.joining()).equals(
                Arrays.stream(str2.split("")).sorted().collect(Collectors.joining()));
        if(equals){
            System.out.println("anagram");
        }else{
            System.out.println("not a anagram");
        }

        // with the help of reverse() function
       /* String firstInput = "keep";
        String secondInput = "peek";
        if(firstInput.length()==secondInput.length()){
            StringBuffer buffer = new StringBuffer(firstInput);
            String firstInputRevesrse = buffer.reverse().toString();
            if(firstInputRevesrse.equals(secondInput)){
                System.out.println("Both String is anagram ");
            }else{
                System.out.println("Not anagram");
            }

        }*/

    }
}