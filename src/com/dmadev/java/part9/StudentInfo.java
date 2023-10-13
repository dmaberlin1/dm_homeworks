package com.dmadev.java.part9;

import java.util.List;

public class StudentInfo {
    private List<StudentName> studentNames;
    private double averageGrade;

    StudentInfo(List<StudentName> studentNames, double averageGrade) {
        this.studentNames = studentNames;
        this.averageGrade = averageGrade;
    }

    List<StudentName> getStudentNames() {
        return studentNames;
    }

    double getAverageGrade() {
        return averageGrade;
    }

    static class StudentName {
        private String firstName;
        private String lastName;

        StudentName(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        String getFirstName() {
            return firstName;
        }

        String getLastName() {
            return lastName;
        }
    }
}

