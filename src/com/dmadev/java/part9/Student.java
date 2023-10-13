package com.dmadev.java.part9;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private int course;
    private List<Integer> grades;

    public Student(String firstName, String lastName, int course, List<Integer> grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.grades = grades;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }
}
