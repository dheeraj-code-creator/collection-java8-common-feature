package com.example.repeatedCharacter;

public class RepeatedCharacter {
    public static void main(String[] args) {
        String str = "indian";
        for(int i =0; i<str.length(); i++){
            boolean flag = false;
            for(int j=i+1; j<str.length(); j++){
                if(str.charAt(i)==str.charAt(j)){
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println("repeated character is: " + str.charAt(i));
            }
        }
    }
}
