package com.dmadev.java.part4;

import java.util.Scanner;

public class Solution {
    public static String convert(String s) {
        // preprocessed string
        String pre = s.replace(" ", "").toUpperCase();
        String output = "";
        for (int i = 0; i != pre.length(); ++i) {
            char ch = pre.charAt(i);
            // if not found in output string
            if (output.indexOf(ch) == -1)
                output += ch;
        }
        return output;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        System.out.println(convert(sc.nextLine()));
        sc.close();
    }
}
