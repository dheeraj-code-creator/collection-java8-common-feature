package com.example.interview.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Practice {

    public static void main(String[] args) {

        String str = "indian";
        Set<String> set = new HashSet<>();
        // output d,a
       /* String collect = Arrays.stream(str.split("")).filter(k -> set.add(k))
                .filter(k->Collections.frequency(Arrays.asList(str.split("")),k)==1)
                .collect(Collectors.joining());
        System.out.println(collect);*/

        /*String collect = Arrays.stream(str.split("")).filter(k -> set.add(k)).collect(Collectors.joining());
        System.out.println("Non repeatable : " + collect);*/
        String collect = Arrays.stream(str.split(""))
                .filter(k -> Collections.frequency(Arrays.asList(str.split("")), k) == 2).collect(Collectors.joining());
        System.out.println(collect);


    }
}
