package com.example.integertolistsorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerToList {
    public static void main(String[] args) {

        int[] num = new int[]{10, 40, 80, 30, 20};

        // integer to List
        // java 8, find 2nd highest number and convert to List<Integer>
        List<Integer> list = Arrays.stream(num).mapToObj(k->(int)k).sorted((o1, o2)->o2.compareTo(o1)-o1.compareTo(o2)).skip(1).limit(1)
                .collect(Collectors.toList());
        System.out.println(list);

        // java 8, find 2nd highest number
        Arrays.stream(num).sorted().skip(num.length-2).limit(1).forEach(System.out::println);


        // java 7
        List<Integer> integerList = new ArrayList<>();
        for(int i: num){
            integerList.add(i);
        }
        System.out.println(integerList);


    }


}
