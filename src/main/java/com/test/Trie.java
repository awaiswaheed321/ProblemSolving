package com.test;

import java.util.HashMap;
import java.util.Map;

class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("orange");
        trie.insert("app");
        System.out.println("done");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("ap"));
        System.out.println(trie.startsWith("al"));
        System.out.println(trie.startsWith("z"));
    }


    Node head;

    public Trie() {
        head = new Node();
    }

    public void insert(String word) {
        Node s = head;
        int i = 0;
        while(i<word.length() && s.map.containsKey(word.charAt(i))) {
            s = s.map.get(word.charAt(i++));
        }
        for(; i<word.length(); i++) {
            Node n = new Node();
            n.val = word.charAt(i);
            s.map.put(word.charAt(i), n);
            s = n;
        }
        s.isComplete = true;
    }

    public boolean search(String word) {
        return wordSearch(word, true);
    }

    public boolean startsWith(String prefix) {
        return wordSearch(prefix, false);
    }

    public boolean wordSearch(String word, Boolean complete) {
        Node s = head;
        for(int i=0; i<word.length(); i++) {
            if(s.map.containsKey(word.charAt(i))) {
                s = s.map.get(word.charAt(i));
            } else {
                return false;
            }
        }
        if(complete) {
            return s.isComplete;
        } else {
            return true;
        }
    }

    static class Node {
        Character val;
        Map<Character, Node> map;
        Boolean isComplete;

        public Node() {
            val = null;
            map = new HashMap<>();
            isComplete = false;
        }
    }
}
