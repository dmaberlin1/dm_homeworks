package com.dmadev.java.part9;

import java.util.*;
import java.util.stream.Collectors;

public class TaskRunner {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", "Smith", 1, List.of(4, 5, 3, 2)));
        students.add(new Student("Bob", "Johnson", 2, List.of(3, 2, 4, 5)));
        students.add(new Student("Eve", "Williams", 1, List.of(5, 4, 5, 5)));
        students.add(new Student("Charlie", "Brown", 3, List.of(3, 2, 3, 4)));

        Map<Integer, StudentInfo> result = students.stream()
                .collect(Collectors.groupingBy(Student::getCourse,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> new StudentInfo(
                                        list.stream()
                                                .sorted(Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName))
                                                .map(student -> new StudentInfo.StudentName(student.getFirstName(), student.getLastName()))
                                                .collect(Collectors.toList()),
                                        list.stream()
                                                .flatMapToInt(student -> student.getGrades().stream().mapToInt(Integer::intValue))
                                                .filter(grade -> grade > 3)
                                                .average()
                                                .orElse(0.0)
                                )
                        )
                ));

        Map<Integer, StudentInfo> sortedResult = new TreeMap<>(result);

        sortedResult.forEach((key, value) -> {
            System.out.println("Course: " + key);
            System.out.println("Average Grade: " + value.getAverageGrade());
            System.out.println("Students:");
            value.getStudentNames().forEach(studentName -> System.out.println(studentName.getFirstName() + " " + studentName.getLastName()));
            System.out.println("---------");
        });
    }
}