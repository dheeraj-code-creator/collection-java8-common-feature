package com.example.collectionfeature;

/*  Map is a collection of Entry. (Map is a outer interface and Entry is a inner interfaces)
        Each Entry is having a (key, value) pair.
        Entry is having 3 methods(getKey(), getValue(), setKey())
        for doing operation in keys and values we have to call Map.Entry (outer interface.inner interface)
        example: 1. entrySet
                 2. Map.Entry
                 3. then apply Entry methods on keys and values.
    HashMap works on the priniple of hashing. (Hashing means conversion of big string to shorter one.)
    HashMap uses HashTable data structure.
    HashMap doesnot provide insertion order.
    HashMap display data based on the hashcode.
        hashcode is generated only for keys not for values.
        Bydefault capacity of HashMap is 16. (i.e 16 buckets will be created once we create the object of HashMap)
        Bydefault fill ratio/load factor of HashMap is 0.75. (i.e once 75% of Entry<K, V> is filled in all the buckets,
                                                              after that it will create new object).
        bucket is also called nodes.
        if we want we can change both capacity and ratio by using different constructor.
    HashMap doesn't contain duplicate keys, but having duplicate values.
        Ex:(int rollNumber, String names)
    HashMap contains only one null key. (if we provide more than one null key then it will not satisfy above line.)
    HashMap is mostly use when we want to perform search operations.

    when we call put(key, value) method then,
    1. hashcode will be generated for the key, and using hashmap formula bucket/nodes will be decided.
    2. bucket/node capacity is 16 (i.e 0,1,2,3,4.....15)
    3. lets suppose formula calculated index is 4.
    4. then key,value and hashcode for the key all three(key,value,hascode) will be stored to bucket/node 4.

    when we call get(key) method then,
    1. already generated hashcode for the key is used.
    2. after using hashmap formula bucket/nodes will be decided.
    3. then get(key) hashcode and put(key) hascode will be check.
    4. if both hashcode are same, then .equals() methods is called, for cheking both key values.
    5. if both key are also same, then that (key,value) will be return.

    contract:
    * if two objects are equal then they must have same hashcode.

*/

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapExample {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put(101, "Dheeraj");
        map.put(201, "Surbhi");
        map.put(301, "Banti");
        map.put(null, "B");

    //    map.forEach((k,v)-> System.out.println(v));

        // display complete map
        map.entrySet().forEach(System.out::println);

        // display complete list of map
        Object collect = map.entrySet().stream().collect(Collectors.toSet());
        System.out.println(collect);

        // display only map keys
        map.forEach((k,v)->System.out.println(k));

        // display only map values
        map.forEach((k,v)->System.out.println(v));


    }
}
