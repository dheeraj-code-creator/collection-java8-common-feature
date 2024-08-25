package com.example.reverseofstring;

import java.util.ArrayList;
import java.util.List;

public class RevesrseOfString {

    public static void main(String[] args) {
        String str = "dheeraj";
        char[] charArray = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for(int i=str.length()-1; i<str.length(); i--){
            list.add(charArray[i]);
            if(i==0){
                break;
            }
        }
        System.out.println(list);
    }
}
