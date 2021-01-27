package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        Main main = new Main();
        String binaryResult = main.binaryConverter(MESSAGE);
        String[] binaryArray = binaryResult.split("");
        main.ChuckNorris(binaryArray);
    }
    public String binaryConverter(String message){
        String s= message;
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
    public void ChuckNorris(String[] binaryArray){
        int[] intArray = new int[binaryArray.length];
        int ones=0;
        int zeros=0;
        String[] answer;
        for(int i = 0; i < binaryArray.length;i++){
            intArray[i] = Integer.parseInt(binaryArray[i]);
        }
        for(int i = 0; i < intArray.length;i++){
            for(int j = i+1;j< intArray.length;j++){
                if(intArray[i]==intArray[j]&& intArray[i]==1){
                    ones+=2;
                }
                else if(intArray[i]==intArray[j]&& intArray[i]==0){
                    zeros+=2;
                }
                else if(intArray[i]!=intArray[j]&& intArray[i]==1){
                    ones+=1;
                }
                else if(intArray[i]!=intArray[j]&& intArray[i]==0){
                    zeros+=1;
                }
                AnswerCreator(ones, zeros);
                ones = 0;
                zeros = 0;
                break;
            }

        }
    }
    public void AnswerCreator(int ones, int zeros){
        String answer = "";
        if(ones > 0){
            answer+="0 ";
            for(int i = 0;i<ones;i++){
                answer+="0";
            }
            answer+=" ";
        }
        if(zeros>0){
            answer+="00 ";
            for(int i = 0;i<zeros;i++){
                answer+="0";
            }
            answer+=" ";
        }
        System.out.println(answer);
    }
}
