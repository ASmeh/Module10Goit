package org.example;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Task1 task1 = new Task1();
        task1.execute(System.getProperty("user.dir")+"\\src\\main\\java\\org\\example\\test.txt");

        Task2 task2 = new Task2();
        task2.execute(System.getProperty("user.dir")+"\\src\\main\\java\\org\\example\\test2.txt");

        Task3 task3 = new Task3();
        task3.execute(System.getProperty("user.dir")+"\\src\\main\\java\\org\\example\\words.txt");
    }
}