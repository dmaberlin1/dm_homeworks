package com.dmadev.java.part15;

import java.time.LocalDateTime;


class Complaint {
    private int id;
    private LocalDateTime dateTime;
    private String name;
    private String phone;
    private String issue;

    public Complaint(int id, LocalDateTime dateTime, String name, String phone, String issue) {
        this.id = id;
        this.dateTime = dateTime;
        this.name = name;
        this.phone = phone;
        this.issue = issue;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getIssue() {
        return issue;
    }
}