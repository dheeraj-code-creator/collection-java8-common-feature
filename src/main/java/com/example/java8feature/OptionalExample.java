package com.example.java8feature;

import java.util.Optional;

// Optional Class is used to handle the null pointer exception.
public class OptionalExample {
    public static void main(String[] args) {

        // this will throw null pointer exception
        /*String[] str = new String[10];
        String lowerCase = str[5].toLowerCase();
        System.out.println(lowerCase);*/

        String[] str = new String[10];
        Optional<String> checkNull = Optional.ofNullable(str[5]);
        if(checkNull.isPresent()){
            System.out.println(str[5].toLowerCase());
        }else{
            System.out.println("str[5] value is: " + str[5]);
        }




    }
}
