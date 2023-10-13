package com.dmadev.java.part15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LogFileProcessor {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    private static final String COMPLAINTS_FILE = "complaints.log";
    private static final String CALLS_FILE = "calls.log";

    public List<Complaint> readComplaints() {
        List<Complaint> complaints = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(COMPLAINTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                Complaint complaint = new Complaint();
                complaint.setClientNumber(Integer.parseInt(parts[0]));
                complaint.setDateTime(LocalDateTime.parse(parts[1], FORMATTER));
                complaint.setName(parts[2]);
                complaint.setPhone(parts[3]);
                complaint.setIssue(parts[4]);
                complaints.add(complaint);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return complaints;
    }

    public void writeCall(Call call) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CALLS_FILE, true))) {
            String line = String.format("%d, %s, %s\n", call.getClientNumber(),
                    call.getDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")),
                    call.getFormattedPhone());
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}