package com.example.java8feature;

import java.util.Arrays;
import java.util.List;

public class CompareTwoListExample {

    public static void main(String[] args) {
        List<Integer> firstList = Arrays.asList(123, 456, 786);
        List<Integer> secondList = Arrays.asList(786, 123, 456);

        // by Java 8
 //     boolean resultFlag = firstList.stream().allMatch(list -> firstList.containsAll(secondList));
        boolean resultFlag = firstList.stream().allMatch(secondList::contains);
        if(resultFlag){
            System.out.println("matched");
        }else{
            System.out.println("Not matched");
        }


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
