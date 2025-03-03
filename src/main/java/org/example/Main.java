package org.example;
import org.example.util.ClassGenerator;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.nio.file.*;
public class Main {
    public static void main(String[] args) {
        //Change The Path to the Json File
        String JsonPath ="";
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(JsonPath)));
            JSONArray jsonArray = new JSONArray(jsonString);
            ClassGenerator classGenerator = new ClassGenerator(jsonArray);
            classGenerator.Generate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}