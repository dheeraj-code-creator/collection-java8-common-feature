package com.example.zeroesandones;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrangeOrder {

    public static void main(String[] args) {

        // by java 8
        List<Integer> list = Arrays.asList(0,1,0,1,0,1,0,1);
        List<Integer> result = list.stream().sorted().collect(Collectors.toList());
        System.out.println(result);

        System.out.println("###############################################################");

        // by java 7
        String str = "01010101";
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        String s = new String(charArray);
        System.out.println(s);

        System.out.println("###############################################################");

        // without using sort() function
        String input = "01010101";
        char[] charInputArray = input.toCharArray();
        for(int i=0; i<charInputArray.length; i++){
            for(int j=i+1; j<charInputArray.length; j++){
                if(charInputArray[i]>charInputArray[j]){
                    char temp = charInputArray[j];
                    charInputArray[j]=charInputArray[i];
                    charInputArray[i]=temp;
                }
            }
        }
        System.out.println(charInputArray);
    }
}
