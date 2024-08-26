package com.example.comparetwolist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompareTwoListExample {

    public static void main(String[] args) {
        List<Integer> firstList = Arrays.asList(123, 456, 786);
        List<Integer> secondList = Arrays.asList(786, 123, 456);

        // by Java 8
        // compare two list
        List<String> list1 = Arrays.asList("A", "B", "C");
        List<String> list2 = Arrays.asList("A", "B", "C", "D");

        // compare two list are equal or not
      //  boolean allMatch = list1.stream().allMatch(k -> list2.containsAll(k));
        boolean allMatch = list1.stream().allMatch(list2::contains);
        System.out.println("is both list is equal: " + allMatch);

        // find out the similar value from both the list
      //  List<String> similarList = list2.stream().filter(k -> list1.contains(k)).collect(Collectors.toList());
        List<String> similarList = list2.stream().filter(list1::contains).collect(Collectors.toList());
        System.out.println("similarList: " + similarList);

        // find out the difference value from both the list
        List<String> differenceList = list2.stream().filter(k -> ! list1.contains(k)).collect(Collectors.toList());
        System.out.println("differenceList: " + differenceList);


        // by Java 7

        // first method
        boolean contains = firstList.containsAll(secondList);
        if(contains){
            System.out.println("equal");
        }else{
            System.out.println("Not equal");
        }

        // second method
        boolean equalFlag = false;
        if(firstList.size()==secondList.size()){
            for(Integer result: firstList){
                if(secondList.contains(result)){
                    equalFlag = true;
                }else{
                    equalFlag = false;
                    break;
                }
            }
            if(equalFlag){
                System.out.println("Both list are equals");
            }else{
                System.out.println("Both list are Not equals");
            }

        }else{
            System.out.println("both list is having different size, Not equal");
        }
    }
}
