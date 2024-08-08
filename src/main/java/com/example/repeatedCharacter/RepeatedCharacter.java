package com.example.repeatedCharacter;

public class RepeatedCharacter {
    public static void main(String[] args) {
        String str = "india";
        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<str.length(); j++){
                if(str.charAt(i)==str.charAt(j)){
                    System.out.println( "repeated string is: " + str.charAt(j));
                }
            }
        }
    }
}
