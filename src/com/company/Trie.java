package com.company;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private TrieNode root;

    public Trie(Map<String, String> map) throws TrieException {
        this.root = new TrieNode();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.addEntry(entry);
        }
    }

    private void addEntry(Map.Entry<String, String> entry) throws TrieException {
        TrieNode currentNode = this.root;
        for (char letter : entry.getKey().toCharArray()) {
            if (!currentNode.children.containsKey(letter)) {
                currentNode.children.put(letter, new TrieNode());
            }
            currentNode = currentNode.children.get(letter);
        }
        if (currentNode.value != null) {
            throw new TrieException("Duplicate entry: " + entry.getKey());
        }
        currentNode.value = entry;
    }

    public Map.Entry<String, String> findWordInInput(String input) {
        TrieNode currentNode = this.root;
        Map.Entry<String, String> longestMatch = null;
        for (char letter : input.toCharArray()) {
            if (currentNode.children.containsKey(letter)) {
                currentNode = currentNode.children.get(letter);
                if (currentNode.value != null) {
                    longestMatch = currentNode.value;
                }
            } else {
                break;
            }
        }
        return longestMatch;
    }

    public class TrieException extends Exception {
        public TrieException(String message) {
            super(message);
        }
    }

    private class TrieNode {
        public Map.Entry<String, String> value;
        public Map<Character, TrieNode> children;

        public TrieNode() {
            this.value = null;
            this.children = new HashMap<>();
        }
    }
}
