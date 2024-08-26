package com.example.findnamefromtwolist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindNameFromTwoList {
    public static void main(String[] args) {
        // We have two list
        // 1st list contains user object
        // 2nd list contains user id's.
        // result: compare two list and print all the names based on the 2nd list id's. use java8 stream

        List<User> userList = Arrays.asList(new User(101, "Dheeraj"),
                                            new User(201, "Banti"),
                                            new User(301, "Surbhi"));
        List<Integer> userIdNumberList = Arrays.asList(301, 201);
        List<String> nameList = new ArrayList<>();

        // method 1 with the help of map
        userList.stream().map(
                k -> {
                    for (Integer num : userIdNumberList) {
                        if (k.getId() == num) {
                            nameList.add(k.getName());
                        }
                    }
                    return nameList;
                }
        ).collect(Collectors.toList());
        System.out.println(nameList);

        // method 2 with the help of filter and map
    //  List<String> list = userList.stream().filter(k -> userIdNumberList.contains(k.getId())).map(n -> n.getName()).collect(Collectors.toList());
        List<String> list = userList.stream().filter(k -> userIdNumberList.contains(k.getId())).map(User::getName).collect(Collectors.toList());
        System.out.println(list);

    }
}
