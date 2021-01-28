package com.company;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        Solution main = new Solution();
        String binaryResult = main.binaryConverter(MESSAGE);
        System.out.println(main.ChuckNorris(binaryResult));
    }

    public String binaryConverter(String message) {
        String s = message;
        byte[] bytes = s.getBytes();
        StringBuilder binary = new StringBuilder();
        for (int j = 0; j < bytes.length; j++) {
            int val = bytes[j];
            for (int i = 0; i < 7; i++) {
                val <<= 1;
                binary.append((val & 128) == 0 ? 0 : 1);
            }
        }
        return binary.toString();
    }

    public String ChuckNorris(String binary) {
        StringBuilder binToUn = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                if (i == 0 || (i > 0 && binary.charAt(i - 1) == '0')) {
                    if (i == 0) binToUn.append("0 0");
                    if (i > 0) binToUn.append(" 0 0");
                }
                if ((i > 0 && binary.charAt(i - 1) == '1')) {
                    binToUn.append("0");
                }
            }
            if (binary.charAt(i) == '0') {
                if ((i == 0) || (i > 0 && binary.charAt(i - 1) == '1')) {
                    if (i == 0) binToUn.append("00 0");
                    if (i > 0) binToUn.append(" 00 0");
                }
                if ((i > 0 && binary.charAt(i - 1) == '0')) {
                    binToUn.append("0");
                }
            }
        }
        binary = binToUn.toString();
        return binary;
    }
}


