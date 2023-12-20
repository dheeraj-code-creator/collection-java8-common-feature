package com.example.java8feature;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AllJava8FeatureProgram {
    public static void main(String[] args) {

        // predicate example
        int i =10;
        Predicate<Integer> predicate = a->a>i;
        System.out.println(predicate.test(20));

        // consumer example
        /*String str = "dheeraj";
        Consumer<String> consumer = a->System.out.println(a.toUpperCase());
        consumer.accept(str);*/

        // function example
        /*String str = "dheeraj";
        Function<String, Integer> function = a->a.length();
        System.out.println(function.apply(str));*/

        // second highest number
        /*List<Integer> list = Arrays.asList(10,20,30,90,70,80);
        list.stream().sorted(((o1, o2) -> o2.compareTo(o1)-o1.compareTo(o2))).skip(1).limit(1).forEach(System.out::println);*/

        // second highest string
        /*List<String> list = Arrays.asList("abcd","a","abc","ab");
        list.stream().sorted((o1,o2)->o2.compareTo(Integer.toString(o1.length()))-o1.compareTo(Integer.toString(o2.length())))
        .skip(1).limit(1).forEach(System.out::println);*/


        // sort names in ascending order
        /*List<String> list = Arrays.asList("D","E","C","A","B");
        List<String> collect = list.stream().sorted((o1, o2) -> o1.compareTo(o2) - o2.compareTo(o1)).collect(Collectors.toList());
        System.out.println(collect);*/

        // print names start with "E"
        /*List<String> list = Arrays.asList("Dheeraj","Eagle","Cyrus","Ajit","Bunty");
        list.stream().filter(a->a.startsWith("E")).forEach(System.out::println);*/

        // print names start with "D" and concat with "kumar"
        /*List<String> list = Arrays.asList("Dheeraj","Eagle","Cyrus","Ajit","Bunty");
        list.stream().filter(a->a.startsWith("D")).map(k->k.concat(" kumar")).forEach(System.out::println);*/

    }
}