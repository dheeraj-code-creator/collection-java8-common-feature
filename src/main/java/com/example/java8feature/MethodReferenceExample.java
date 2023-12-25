package com.example.java8feature;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Dheeraj");
        list.add("Surbhi");
        list.add("Banti");

        // normal print
        list.stream().forEach(a-> System.out.println(a));

        // method reference print
        list.stream().forEach(System.out::println);
    }
}
