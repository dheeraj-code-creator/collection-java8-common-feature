package com.example.collectionfeature;

// maintains insertion order and doesnot contains duplicates.

import java.util.LinkedHashSet;

public class LinkedHashSetExample {

    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(70);
        linkedHashSet.add(2);
        linkedHashSet.add("z");
        linkedHashSet.add("A");

        linkedHashSet.forEach(System.out::println);

    }
}
