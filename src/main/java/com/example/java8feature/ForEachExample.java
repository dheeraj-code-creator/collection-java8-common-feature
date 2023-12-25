package com.example.java8feature;

import java.util.ArrayList;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Dheeraj");
        list.add("Surbhi");
        list.add("Banti");

        list.forEach(System.out::println);
    }
}
