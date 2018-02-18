package com.company;


import java.util.*;

public class Main {

    private static Map<String, String> database = Map.ofEntries(
            Map.entry("ein", "C:\\recordings\\ein.mp3"),
            Map.entry("zwei", "C:\\recordings\\zwei.mp3"),
            Map.entry("zwanzig", "C:\\recordings\\zwanzig.mp3"),
            Map.entry("dreizig", "C:\\recordings\\dreizig.mp3"),
            Map.entry("drei", "C:\\recordings\\drei.mp3"),
            Map.entry("und", "C:\\recordings\\und.mp3")
    );


    public static void main(String[] args) {

        String input = "dreiundzwanzig";
        TrieSolution.synthesize(input, database);
    }
}
