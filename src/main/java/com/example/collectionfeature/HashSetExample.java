package com.example.collectionfeature;

/*Set: interface
HashSet: class
Maintains no order, displays data based on the hashcode
It doesn't allow duplicates. if duplicate elements are there it will not throw any error. it prints only once*/

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {

    public static void main(String[] args) {
        Set set = new HashSet<>();
        set.add("Dheeraj");
        set.add("Surbhi");
        set.add("Banti");
        set.add("Surbhi");
        set.add(10);
        set.add(5);
        set.add(10);

        set.forEach(k-> System.out.println(k));
        // or
        set.forEach(System.out::println);

    }
}
