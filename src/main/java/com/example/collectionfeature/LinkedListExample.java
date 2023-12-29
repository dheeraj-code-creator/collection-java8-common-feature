package com.example.collectionfeature;

/* Displays data in insertion order.
   List is interface
   LinkedList is a class*/

import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(12);
        linkedList.add(50);
        linkedList.add("A");
        linkedList.add("Z");

        linkedList.forEach(System.out::println);


    }
}
