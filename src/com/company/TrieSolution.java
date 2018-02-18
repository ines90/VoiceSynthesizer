package com.company;

import java.util.Map;

public class TrieSolution {
    public static void synthesize(String input, Map<String, String> database) {
        try {
            Trie trie = new Trie(database);
            for (int i = 0; i < input.length(); ) {
                Map.Entry<String, String> databaseEntry = trie.findWordInInput(input.substring(i));
                if (databaseEntry != null) {
                    System.out.println(databaseEntry.getValue());
                    i += databaseEntry.getKey().length();
                } else {
                    System.out.println("No matching word starting from: " + input.charAt(i));
                    i++;
                }
            }
        } catch (Trie.TrieException e) {
            System.out.println("Error while creating Trie: " + e.getMessage());
        }
    }
}
