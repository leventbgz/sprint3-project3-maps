package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<Employee> employeesList = new LinkedList<>();
        employeesList.add(new Employee(1, "levent", "bogaz"));
        employeesList.add(new Employee(2, "giulia", "spreafico"));
        employeesList.add(new Employee(1, "levent", "bogaz"));
        employeesList.add(new Employee(3, "john", "doe"));
        System.out.println(employeesList);
        List<Employee> duplicates = findDuplicates(employeesList);
        System.out.println(duplicates);

        Map<Integer, Employee> unics = findUniques(employeesList);
        System.out.println(unics);

        System.out.println("******************************");
        System.out.println(removeDuplicates(employeesList));

    }


    public static List<Employee> findDuplicates(List<Employee> employees) {
        Map<Integer, Employee> employeesMap = new HashMap<>();
        List<Employee> duplicatedEmployees = new LinkedList<>();

        for (Employee employee : employees) {
            if (employee == null) {
                System.out.println("Employee is" + null + "  and has not been initialized");
                continue;
            }

            if (employeesMap.containsKey(employee.getId())) {
                duplicatedEmployees.add(employee);
            } else {
                employeesMap.put(employee.getId(), employee);
            }
        }
        return duplicatedEmployees;
    }

    public static Map<Integer, Employee> findUniques (List<Employee> employees) {
        Map<Integer, Employee> unicEmployees = new HashMap<>();

        for (Employee employee : employees) {
            if (employee == null) {
                System.out.println("Employee is" + null + "  and has not been initialized");
                continue;
            }

            if (!unicEmployees.containsKey(employee.getId())) {
                unicEmployees.put(employee.getId(), employee);
            }
        }
        return unicEmployees;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees){
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> duplicatesRemoved = new ArrayList<>(uniques.values()); //mapName.values() returns an arrayList
        duplicatesRemoved.removeAll(duplicates);

        return duplicatesRemoved;
    }
}