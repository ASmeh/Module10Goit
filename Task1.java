package org.example;

import java.io.FileReader;
import java.io.IOException;
import  java.io.BufferedReader;
import java.util.ArrayList;

public class Task1 {
    public void execute(String path){
        readFile(path);
        printNumbers();
    }
    private void printNumbers(){
        for(String number:validNumbers){
            System.out.println(number);
        }
    }
    private void readFile(String path){
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = reader.readLine())!=null){
                if(isValidNumber(line)){
                    validNumbers.add(line);
                }
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    private boolean isValidNumber(String line) {
        String pattern1 = "\\(\\d{3}\\)-? \\d{3}-?\\d{4}";
        String pattern2 = "(?:\\d{3}-){2}\\d{4}";
        return line.matches(pattern1) || line.matches(pattern2);
    }
    private ArrayList<String> validNumbers = new ArrayList<>();
}
