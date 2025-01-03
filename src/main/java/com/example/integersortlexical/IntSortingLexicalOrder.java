package com.example.integersortlexical;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntSortingLexicalOrder {

    public static void main(String[] args) {
        // input:  0,3,1,0,2,0
        // output: 1,2,3,0,0,0

        int[] number = new int[]{0,3,1,0,2,0};
        List<Integer> numberList = Arrays.asList(0,3,1,0,2,0);

        List<Integer> collect = Arrays.stream(number).mapToObj(k -> (int) k)
                .sorted(Comparator.comparingInt(k -> k.equals(0) ? 1 : 0).thenComparingInt(k -> (int) k)).collect(Collectors.toList());
        System.out.println(collect);

        /*List<Integer> collect1 = numberList.stream()
                .sorted(Comparator.comparingInt(k -> k.equals(0) ? 1 : 0).thenComparingInt(k -> (int) k)).collect(Collectors.toList());
        System.out.println(collect1);*/


    }
}
