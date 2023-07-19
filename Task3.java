package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.Comparator;

public class Task3 {
    private Map<String,Integer> wordsCount = new HashMap<>();
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
        Comparator<String> valueComparator = new Comparator<String>() {
            public int compare(String k1, String k2)
            {
                int comp = wordsCount.get(k1).compareTo(
                        wordsCount.get(k2));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }

        };
        TreeMap<String, Integer> sortedMap = new TreeMap<>(Collections.reverseOrder(valueComparator));
        sortedMap.putAll(wordsCount);
        for(Entry<String,Integer> entry:sortedMap.entrySet()){
            System.out.printf("%s %d\n",entry.getKey(),entry.getValue());
        }
    }
}
