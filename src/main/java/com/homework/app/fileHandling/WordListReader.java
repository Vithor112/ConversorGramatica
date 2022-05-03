package com.homework.app.fileHandling;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordListReader {
    File file;
    private final ArrayList<String> listString = new ArrayList<>();

    public ArrayList<String> getListString() {
        return listString;
    }

    public WordListReader(File file){
        this.file = file;
        readFile();
    }

    // Read all words and store it in an arrayList
    private void readFile(){
        try {
            FileReader fileReader = new FileReader(file);
            int ch;
            while ( (ch = fileReader.read()) != -1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((char)ch);
                while ((char) (ch = fileReader.read()) != '\n' && ch != '\r'){
                    stringBuilder.append((char)ch);
                }
                listString.add(stringBuilder.toString());
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
