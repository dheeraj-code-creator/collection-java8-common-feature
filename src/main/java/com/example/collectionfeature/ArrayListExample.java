package com.example.collectionfeature;

/*
List: interface
ArrayList: class
Maintains no order, displays data in insertion order.
*/

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("Dheeraj");
        list.add("Surbhi");
        list.add("Banti");
        list.add(10);
        list.add("Surbhi");


        System.out.println(list.size());
        System.out.println(list.get(0));

        list.forEach(k-> System.out.println(k));
           // or
        list.forEach(System.out::println);

    }
}
