package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Task1 task1 = new Task1();
        task1.execute("D:\\Practice\\GoIT\\module10\\src\\main\\java\\org\\example\\test.txt");

        Task2 task2 = new Task2();
        task2.execute("D:\\Practice\\GoIT\\module10\\src\\main\\java\\org\\example\\test2.txt");

        Task3 task3 = new Task3();
        task3.execute("D:\\Practice\\GoIT\\module10\\src\\main\\java\\org\\example\\words.txt");
    }
}