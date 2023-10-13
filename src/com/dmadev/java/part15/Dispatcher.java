package com.dmadev.java.part15;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Dispatcher {
    private static final int MAX_DISPATCHERS = 3;
    private static final String LOG_FILE_PATH = "complaints.log";
    private static final String CALL_LOG_PATH = "calls.log";

    private Pattern phonePattern = Pattern.compile("\\+375\\s*\\(?(\\d{2})\\)?\\s*(\\d{3})[-\\s]*(\\d{2})[-\\s]*(\\d{2})");

    public void processComplaints() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE_PATH));
            String line;
            while ((line = reader.readLine()) != null) {
                Complaint complaint = parseComplaint(line);
                if (complaint != null) {
                    dispatchCall(complaint);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Complaint parseComplaint(String line) {
        String[] parts = line.split(", ");
        if (parts.length == 5) {
            int id = Integer.parseInt(parts[0]);
            LocalDateTime dateTime = LocalDateTime.parse(parts[1]);
            String name = parts[2];
            String phone = parts[3];
            String issue = parts[4];
            return new Complaint(id, dateTime, name, phone, issue);
        }
        return null;
    }

    private void dispatchCall(Complaint complaint) {
        String formattedPhone = formatPhone(complaint.getPhone());
        CallRecord callRecord = new CallRecord(complaint.getId(), LocalDateTime.now(), formattedPhone);
        writeCallLog(callRecord);
        System.out.println("Calling customer: " + complaint.getName() + " at " + formattedPhone);
    }

    private String formatPhone(String phone) {
        Matcher matcher = phonePattern.matcher(phone);
        if (matcher.matches()) {
            return String.format("+375 (%s) %s-%s-%s", matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(4));
        }
        return phone; // return unchanged if phone number does not match expected pattern
    }

    private void writeCallLog(CallRecord callRecord) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CALL_LOG_PATH, true))) {
            writer.println(callRecord.getComplaintId() + ", " +
                    callRecord.getCallDateTime() + ", " +
                    callRecord.getFormattedPhone());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}