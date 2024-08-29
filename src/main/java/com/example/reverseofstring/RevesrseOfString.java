package com.example.reverseofstring;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RevesrseOfString {

    public static void main(String[] args) {

        // java 7
        String str = "dheeraj";
        for(int i=str.length()-1; i<str.length(); i--){
            System.out.println(str.charAt(i));
            if(i==0){
                break;
            }
        }

        // java 8
        String reverse = Stream.of(str.split("")).reduce("", (a, b) -> b + a);
        System.out.println(reverse);

    }
}
