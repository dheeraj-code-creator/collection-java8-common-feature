package com.example.interview.programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {

        // find out second highest number
        List<Integer> numberList = Arrays.asList(10, 5, 9, 34, 50, 6);
        numberList.stream().sorted((o1,o2)->o2.compareTo(o1)-o1.compareTo(o2)).skip(1).limit(1).forEach(System.out::println);

System.out.println("###############################");

        // find out repeated character of the string
        String str = "india";
        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<str.length(); j++){
                if(str.charAt(i)==str.charAt(j)){
                    System.out.println( "repeated string is: " + str.charAt(j));
                }
            }
        }

System.out.println("###############################");

        // check the two strings are anagram or not
        // with the help of reverse() function
        String firstInput = "keep";
        String secondInput = "peek";
        if(firstInput.length()==secondInput.length()){
            StringBuffer buffer = new StringBuffer(firstInput);
            String firstInputRevesrse = buffer.reverse().toString();
            if(firstInputRevesrse.equals(secondInput)){
                System.out.println("Both String is anagram ");
            }else{
                System.out.println("Not anagram");
            }
        }

        // using charArray
        if(firstInput.length()==secondInput.length()){
            char[] firstCharArray = firstInput.toCharArray();
            char[] secondCharArray = secondInput.toCharArray();
            Arrays.sort(firstCharArray);
            Arrays.sort(secondCharArray);
            boolean equalsFlag = Arrays.equals(firstCharArray, secondCharArray);
            if(equalsFlag){
                System.out.println("both strings are anagram");
            }else{
                System.out.println("strings are not anagram");
            }
        }else{
            System.out.println("strings are not anagram");
        }

System.out.println("###############################");

        // substring of a string
        String date = "08-Aug-2024";

        // print only month
        String month = date.substring(date.indexOf("-")+1, date.lastIndexOf("-"));
        System.out.println("month : " + month);

        // print only day
        String day = date.substring(0, date.indexOf("-"));
        System.out.println("day : " + day);

        // print only year
        String year = date.substring(date.lastIndexOf("-")+1);
        System.out.println("year : " + year);

System.out.println("###############################");
        // print 00001111

        // by java 8
        List<Integer> integerList = Arrays.asList(1,0,0,1,0,1,0,1);
        List result = integerList.stream().sorted().collect(Collectors.toList());
        System.out.println(result);

        // by java 7
        String input = "01010101";
        char[] output = input.toCharArray();
        Arrays.sort(output);
        System.out.println(output);

        // by using loop
        char[] inputArray = input.toCharArray();
        for(int i=0; i<inputArray.length;i++){
            for(int j=i+1; j<inputArray.length; j++){
                if(inputArray[i]>inputArray[j]){
                    char temp = inputArray[j];
                    inputArray[j]= inputArray[i];
                    inputArray[i]= temp;
                }
            }
        }
        System.out.println(inputArray);

    }
}
