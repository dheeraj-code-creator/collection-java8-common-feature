package com.example.primitivetowrapper;

import java.util.stream.Stream;

public class PrimitiveConversion {

    public static void main(String[] args) {
        // convert int to Integer
        int numInt = 10;
        //  Integer integerNum = Stream.of(numInt).map(k -> (int) k).findFirst().get();
        //  Integer integerNum = Stream.of(numInt).map(k->Integer.valueOf(k)).findFirst().get();
        Integer integerNum = Stream.of(numInt).map(Integer::valueOf).findFirst().get();
        System.out.println(integerNum);

        // convert Integer to int
        Integer integer = 50;
        int asInt = Stream.of(integer).mapToInt(k -> (int) k).findFirst().getAsInt();
        System.out.println(asInt);

        // convert double to Double
        double numDouble = 100;
        Double doubleNum = Stream.of(numDouble).map(Double::valueOf).findFirst().get();
        System.out.println(doubleNum);
    }
}
