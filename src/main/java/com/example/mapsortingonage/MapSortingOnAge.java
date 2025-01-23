package com.example.mapsortingonage;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MapSortingOnAge {

    public static void main(String[] args) {
        Map<Integer, Person> map = new HashMap<>();
        map.put(100, new Person(1, 35, "Alice"));
        map.put(200, new Person(2, 45, "Bob"));
        map.put(300, new Person(3, 25, "Sam"));

        // print whole map both key and value
        // map.entrySet().forEach(System.out::println);

        // print only key
        // map.entrySet().forEach(k->System.out.println(k.getKey()));

        // print only values
        // map.entrySet().forEach(k-> System.out.println(k.getValue()));

        // sort map based on the age
        // increasing order
        map.entrySet().stream().sorted(Comparator.comparing(k->k.getValue().getAge())).forEach(System.out::println);

        // decreasing order
        map.entrySet().stream().sorted((o1,o2)->o2.getValue().getAge() - o1.getValue().getAge()).forEach(System.out::println);



    }
}
