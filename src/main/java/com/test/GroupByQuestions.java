package com.test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByQuestions {

    public static void main(String[] args) {
        // Test Case 1: Group words by their length
        List<String> words = Arrays.asList("apple", "bat", "ball", "cat", "dog");
        System.out.println(groupByLength(words)); // Group by word length

        // Test Case 2: Group words by their first letter
        System.out.println(groupByFirstLetter(words)); // Group by first letter

        // Test Case 3: Group words by even or odd length
        System.out.println(groupByEvenOddLength(words)); // Group by even or odd length

        // Test Case 4: Group words by their frequency (how many times they appear in the list)
        List<String> wordList = Arrays.asList("cat", "bat", "cat", "apple", "apple", "apple");
        System.out.println(groupByFrequency(wordList)); // Group by word frequency

        // Test Case 5: Group words by the number of vowels in each word
        System.out.println(groupByVowels(words)); // Group by number of vowels
    }

    // Question 1: Group words by their length
    public static Map<Integer, List<String>> groupByLength(List<String> words) {
        return words.stream().collect(Collectors.groupingBy(String::length));
    }

    // Question 2: Group words by their first letter
    public static Map<Character, List<String>> groupByFirstLetter(List<String> words) {
        // Implement this method
        return words.stream().collect(Collectors.groupingBy(x -> x.charAt(0)));
    }

    // Question 3: Group words by their length being even or odd
    public static Map<String, List<String>> groupByEvenOddLength(List<String> words) {
        // Implement this method
        return words.stream().collect(Collectors.groupingBy(x -> x.length() % 2 == 0 ? "Even" : "Odd"));
    }

    // Question 4: Group words by their frequency (how many times they appear in the list)
    public static Map<String, Long> groupByFrequency(List<String> words) {
        // Implement this method
        return words.stream().collect(Collectors.toMap(k -> k, k->1L, Long::sum));
    }

    // Question 5: Group words by the number of vowels in each word
    public static Map<Long, List<String>> groupByVowels(List<String> words) {
        // Implement this method
        return words.stream().collect(Collectors.groupingBy(str -> str.chars()
                .filter(c -> "aeiouAEIOU".indexOf(c) != -1)
                .count()));
    }
}
