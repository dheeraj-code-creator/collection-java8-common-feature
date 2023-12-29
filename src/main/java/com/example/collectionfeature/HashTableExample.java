package com.example.collectionfeature;

/*HashTable uses hashtable datastructure, it is synchronized, displays value based on hashcode
It doesnot contain any null keys. it will throw null pointer exception if key is null
initial capacity : 11
ratio/load factor: 0.75*/

import java.util.Hashtable;

public class HashTableExample {

    public static void main(String[] args) {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        hashtable.put(101, "Dheeraj");
        hashtable.put(201, "Surbhi");
        hashtable.put(301, "Banti");
        hashtable.put(301, "A");
      //  hashtable.put(null, "B");

        hashtable.entrySet().forEach(System.out::println);

    }
}
