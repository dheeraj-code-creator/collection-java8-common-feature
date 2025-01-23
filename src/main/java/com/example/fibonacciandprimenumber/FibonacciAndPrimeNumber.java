package com.example.fibonacciandprimenumber;

import java.util.stream.IntStream;

public class FibonacciAndPrimeNumber {

    public static void main(String[] args) {

        // find out fibonacci of 4
        int number =5;  // number = [1,5]

        int asInt = IntStream.rangeClosed(1, number).reduce((a, b) -> a * b).getAsInt();
        System.out.println("fibonacci: " + asInt);

        // find out all the prime numbers between 1-15
        int num = 15;
        int i=1, j=1;

        for(i=1; i<=num; i++){
            boolean temp = true;
            for(j=2; j<i; j++){
                if(i%j==0){
                    temp = false;
                }
            }
            if(temp){
                System.out.println(i);
            }
        }


    }
}
