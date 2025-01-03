package com.example.groupby;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeDemo {

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(100, "Alice", 17000, new Department(1, "HR")),
                new Employee(200, "Bob", 10000, new Department(2, "Finance")),
                new Employee(300, "Smith", 17000, new Department(1, "HR")),
                new Employee(400, "Carey", 19000, new Department(2, "Finance")),
                new Employee(500, "Roy", 10000, new Department(3, "Admin")),
                new Employee(600, "Sam", 10000, new Department(3, "Admin")));

        // get all employees whose department id=2, use filter method
        // employeeList.stream().filter(k -> k.getDepartment().getDepartmentId() == 2).forEach(System.out::println);

        // get all employees by department id, use group by method
        // Map<Department, List<Employee>> mapDepartId = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        // mapDepartId.entrySet().forEach(System.out::println);

        // get all employees by department name, use group by method
        // Map<String, List<Employee>> mapDepartName = employeeList.stream().collect(Collectors.groupingBy(k->k.getDepartment().getDepartmentName()));
        // mapDepartName.entrySet().forEach(System.out::println);

        // count number of employees in each department
        /*Map<String, Long> collect = employeeList.stream()
                .collect(Collectors.groupingBy(k -> k.getDepartment().getDepartmentName(), Collectors.counting()));
        collect.entrySet().forEach(System.out::println);*/

        // count number of employees which is having same salary
        /*Map<Double, Long> collect1 = employeeList.stream().collect(Collectors.groupingBy(k -> k.getSalary(), Collectors.counting()));
        collect1.entrySet().forEach(System.out::println);*/

        // print employee id based on department
        Map<Department, List<Integer>> collect = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getId, Collectors.toList())));
        collect.entrySet().forEach(System.out::println);



    }
}
