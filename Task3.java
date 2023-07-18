package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class Task3 {
    public void execute(String path){
        parseFile(path);
        printMap();
    }
    private void parseFile(String path) {
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while((line=br.readLine())!=null){
                String[] words = line.split(" +");
                for(String word:words) {
                    if(wordsCount.containsKey(word)){
                        wordsCount.put(word,wordsCount.get(word)+1);
                    }
                    else{
                        wordsCount.put(word,1);
                    }
                }
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void printMap(){
        List<Entry<String, Integer>> nlist = new ArrayList<>(wordsCount.entrySet());
        nlist.sort(Entry.comparingByValue(Comparator.reverseOrder()));
        for(Entry pair:nlist){
            System.out.printf("%s %d\n",pair.getKey(),pair.getValue());
        }

    }
    private Map<String,Integer> wordsCount = new HashMap<>();
}
