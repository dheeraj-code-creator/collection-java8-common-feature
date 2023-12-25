package com.example.java8feature;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
Use and close the resources directly inside the try block.
No need to manually close any connection.
finally block is also not required.
*/
public class TryWithResourceExample {
    public static void main(String[] args) throws IOException {

        // Normal try, catch block example
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("abc.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanner.close();

        }

        // try with resource example
        try(Scanner scanner1 = new Scanner(new File("abc.txt"))){
            while(scanner1.hasNext()){
                System.out.println(scanner1.next());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
