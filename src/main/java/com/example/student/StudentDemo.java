package com.example.student;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDemo {

    // marks > 80,          Grade A
    // marks > 60 and < 80, Grade B
    // marks > 40 and < 60, Grade C

    public static void main(String[] args) {

        List<Student> studentList = Arrays.asList(
                new Student(101, "Dheeraj", 85, "A"),
                new Student(201, "Banti", 45, "C"),
                new Student(301, "Surbhi", 65, "B"),
                new Student(401, "Alice", 75, "B"),
                new Student(501, "Bob", 82, "A"),
                new Student(601, "Charlie", 72, "B"),
                new Student(701, "Don", 42, "C"));

        // print list of grade A student
        //studentList.stream().filter(k -> k.getMarks() >= 80).collect(Collectors.toList()).forEach(System.out::println);

        // print list of grade B student
        //studentList.stream().filter(k->k.getMarks()>=60 && k.getMarks()<80).collect(Collectors.toList()).forEach(System.out::println);

        // print only marks, by given grade
        //studentList.stream().filter(k->k.getGrade()=="A").map(k->k.getMarks()).collect(Collectors.toList()).forEach(System.out::println);

        // print marks and name, by given grade (use map function)
        /*List<Student> studentBList = studentList.stream().filter(k -> k.getGrade().equals("B")).map(
                k -> {
                    Student student = new Student();
                    student.setMarks(k.getMarks());
                    student.setName(k.getName());
                    return student;
                }).collect(Collectors.toList());

                studentBList.forEach(k-> System.out.println("Name = " + k.getName() + " , " + "Marks = " + k.getMarks()));*/

        // print marks and name, by given grade in one line
        /*studentList.stream().filter(k->k.getGrade().equals("B")).collect(Collectors.toList())
                .forEach(k-> System.out.println("Name = " + k.getName() + " , " + "Marks = " + k.getMarks()));*/

        // print id, name and marks, by given grade
        /*studentList.stream().filter(k->k.getGrade().equals("C")).collect(Collectors.toList())
                .forEach(k-> System.out.println("Name = " + k.getName() + " , " + "Marks = " + k.getMarks() + ", " + "id = " + k.getId()));*/

        // print only names and marks for all grades.
        //studentList.stream().forEach(k-> System.out.println("Name =" + k.getName() + " , " + "Marks = " + k.getMarks()));

        // print names and marks based on the grades, and also add bonus +5 to marks.
        /*studentList.stream().filter(k->k.getGrade().equals("A")).collect(Collectors.toList())
                .forEach(
                        k->{
                            int bonus = k.getMarks();
                            bonus = bonus + 5;
                            k.setMarks(bonus);
                            System.out.println("Name = " + k.getName() + " , " + "Marks = " + k.getMarks());
                        }
                );*/


        // experiment with foreach amd map method
       /* System.out.println("Original list");
        studentList.forEach(System.out::println);
        StudentDemo demo = new StudentDemo();

        demo.useMapMethod(studentList);
        studentList.forEach(System.out::println);

        demo.useForEachMethod(studentList);
        studentList.forEach(System.out::println);*/
    }

    private void useMapMethod(List<Student> studentList) {
        System.out.println("inside map method");

        // fetch all the student object which is having grade A from the list, add +5 bounus marks to grade A student and update the list.
        studentList.stream().filter(student -> student.getGrade().equals("A")).map(student -> {
            int bonusMarks = student.getMarks();
            bonusMarks = bonusMarks + 5;
            student.setMarks(bonusMarks);
            return student;
        }).collect(Collectors.toList());
    }

    public void useForEachMethod(List<Student> studentList){
        System.out.println("inside foreach method");

        // fetch all the student object which is having grade A from the list, add +5 bounus marks to grade A student and update the list.
        studentList.stream().filter(student -> student.getGrade().equals("A"))
                .forEach(student -> {
                   int bounusMarks = student.getMarks();
                   bounusMarks = bounusMarks + 5;
                   student.setMarks(bounusMarks);
                });
    }
}
