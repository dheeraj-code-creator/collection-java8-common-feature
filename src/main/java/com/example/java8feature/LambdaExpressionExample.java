package com.example.java8feature;

/*Lambda expression is used to implement the functional interface, it acts as a function, so compiler will not
create the .class file.
while using of lambda expression very less code is required.
syntax: (argument) -> { body} */

interface Addition{
    int sumOfNumbers(int num1, int num2);
}

public class LambdaExpressionExample {

    public static void main(String[] args) {

        Addition onlyAddition = (a,b)-> (a + b);
        System.out.println(" Only Addition of Numbers = " + onlyAddition.sumOfNumbers(10, 20));

        Addition addMoreNumbers = (a,b)-> {
            a = a + 10;
            b = b + 10;
            int result = a + b;
            return result;
        };
        System.out.println(" Addition of More Numbers = " + addMoreNumbers.sumOfNumbers(10, 20));
    }

}
