package com.example.collectionfeature;

// maintains insertion order, allows one null keys

import java.util.LinkedHashMap;

public class LinkedHashMapExample {

    public static void main(String[] args) {

        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(101, "Dheeraj");
        linkedHashMap.put(201, "Surbhi");
        linkedHashMap.put(301, "Banti");
        linkedHashMap.put(null, "B");

        linkedHashMap.entrySet().forEach(System.out::println);

    }
}
