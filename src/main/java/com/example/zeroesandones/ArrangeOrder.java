package com.example.zeroesandones;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrangeOrder {

    public static void main(String[] args) {

        // by java 8
        // increasing order
        List<Integer> list = Arrays.asList(0,1,0,1,0,1,0,1);
        List<Integer> result = list.stream().sorted().collect(Collectors.toList());
        System.out.println(result);

        // decreasing order
        // list.stream().sorted((o1,o2)->o2.compareTo(o1)-o1.compareTo(o2)).forEach(System.out::println);

        System.out.println("###############################################################");

        // by java 7
        String inputStr = "01010101";
        char[] output = inputStr.toCharArray();
        Arrays.sort(output);
        System.out.println(output);

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
