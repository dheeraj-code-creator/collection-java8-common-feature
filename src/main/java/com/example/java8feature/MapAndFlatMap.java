package com.example.java8feature;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlatMap {

    public static void main(String[] args) {
        // map: conversion of List of String to List of integer

        List<String> mapResult = Arrays.asList("1","2","3","4","5");
        System.out.println("original list: " + mapResult);
        List<Integer> collect = mapResult.stream().map(Integer::valueOf).collect(Collectors.toList());
        System.out.println("result: " + collect);

        // flatmap: conversion of List<List<String>> to list of integer
        List<List<String>> flatMapResult = Arrays.asList(Arrays.asList("1"), Arrays.asList("2"),
                Arrays.asList("3"), Arrays.asList("4"), Arrays.asList("5"));
        System.out.println("original list: " + flatMapResult);
        List<String> collect1 = flatMapResult.stream().flatMap(k -> k.stream()).collect(Collectors.toList());
        System.out.println("result: " + collect1);
    }
}
