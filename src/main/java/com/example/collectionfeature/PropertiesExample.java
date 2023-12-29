package com.example.collectionfeature;

import java.util.Properties;

/*Properties class is a subclass of hashtable*/


public class PropertiesExample {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties = System.getProperties();

        properties.entrySet().forEach(System.out::println);
    }
}
