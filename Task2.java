package org.example;

import java.io.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Task2 {
    public void execute(String path) throws IOException {
        readFile(path);
        convertToJson();
    }
    private void readFile(String path){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            while((line=br.readLine())!=null){
                String[] parts = line.split(" +");
                users.add(new User(parts[0],Integer.parseInt(parts[1])));
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    private void convertToJson() throws IOException {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);
        FileWriter fw = new FileWriter(new File("D:\\Practice\\GoIT\\module10\\src\\main\\java\\org\\example\\user.json"));
        fw.write(json);
        fw.close();
    }
    private class User{
        private String name;
        private int age;
        public User(String name,int age) {
            this.name = name;
            this.age = age;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
    private ArrayList<User> users = new ArrayList<>();
}
