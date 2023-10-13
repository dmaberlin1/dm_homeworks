package com.dmadev.java.part10;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TaskRunner {
    public static void main(String[] args) {
        Map<Integer, String> prices = readCSV("items-price.csv");
        Map<Integer, String[]> names = readCSVWithHeader("items-name.csv");

        Map<Integer, String> result = new HashMap<>();
        for (int id : prices.keySet()) {
            String price = prices.get(id);
            String[] info = names.get(id);

            if (info != null) {
                String name = info[0];
                result.put(id, name + "," + price);
            }
        }

        writeCSV("result.csv", result);

        // Find missing IDs and write them to errors.csv
        Map<Integer, String> errors = new HashMap<>();
        for (int id : names.keySet()) {
            if (!prices.containsKey(id)) {
                errors.put(id, "");
            }
        }
        writeCSV("errors.csv", errors);
    }

    private static Map<Integer, String> readCSV(String fileName) {
        Map<Integer, String> data = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String value = parts[1];
                data.put(id, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static Map<Integer, String[]> readCSVWithHeader(String fileName) {
        Map<Integer, String[]> data = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String[] values = new String[]{parts[1], parts[2]};
                data.put(id, values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private static void writeCSV(String fileName, Map<Integer, String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Map.Entry<Integer, String> entry : data.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
