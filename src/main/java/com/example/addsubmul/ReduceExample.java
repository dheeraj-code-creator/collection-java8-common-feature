package com.example.addsubmul;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ReduceExample {
    public static void main(String[] args) {

        // get the sum of all numbers
        int[] num = new int[]{2,4,6,-2,0};
        List<Integer> numberList = Arrays.asList(2,4,6,-2,0);

        int asInt = Arrays.stream(num).reduce((a, b) -> a + b).getAsInt();
        System.out.println(asInt);

        Integer integer = numberList.stream().reduce((a, b) -> a + b).get();
        System.out.println(integer);

        // get the product of all numbers between 1 to 6
        int[] product = new int[]{1,6};
        int productRes = IntStream.rangeClosed(1, 6).reduce((a, b) -> a * b).getAsInt();
        System.out.println(productRes);

        // get the longest string from given string
        String[] str = new String[]{"dheeraj", "kumar", "surbhi", "dheeraj-and-surbhi"};
        String longestString = Arrays.stream(str).reduce((a, b) -> a.length() > b.length() ? a : b).get();
        System.out.println(longestString);

        // get the reverse of a string
        String name = "dheeraj";
        String reverseString = Arrays.stream(name.split("")).reduce((a, b) -> b + a).get();
        System.out.println(reverseString);

    }

}
