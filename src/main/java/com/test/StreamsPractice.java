package com.test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsPractice {

    public static void main(String[] args) {
        System.out.println("Q1: " + countEvenNumbers(List.of(1, 2, 3, 4, 5, 6)));
        System.out.println("Q2: " + squareEachElement(List.of(1, 2, 3, 4)));
        System.out.println("Q3: " + filterStringsStartingWithA(List.of("apple", "banana", "avocado", "cat")));
        System.out.println("Q4: " + sumOfList(List.of(10, 20, 30)));
        System.out.println("Q5: " + distinctSortedValues(List.of(5, 3, 5, 1, 3, 2)));

        System.out.println("Q6: " + joinWithDash(List.of("one", "two", "three")));
        System.out.println("Q7: " + countOccurrences(List.of("apple", "banana", "apple", "orange")));
        System.out.println("Q8: " + findMaxNumber(List.of(7, 12, 5, 23, 1)));
        System.out.println("Q9: " + allElementsGreaterThanZero(List.of(0, 1, 2, 3)));
        System.out.println("Q10: " + partitionByEvenOdd(List.of(1, 2, 3, 4, 5, 6)));

        System.out.println("Q11: " + groupByStringLength(List.of("hi", "hello", "world", "bye")));
        System.out.println("Q12: " + flattenListOfLists(List.of(List.of(1, 2), List.of(3, 4), List.of(5))));
        System.out.println("Q13: " + wordLengthMap(List.of("java", "stream", "api")));
        System.out.println("Q14: " + top3LongestStrings(List.of("a", "bb", "ccc", "dddd", "eeeee", "f")));
        System.out.println("Q15: " + frequencyMap(List.of(1, 2, 2, 3, 3, 3, 4)));

        System.out.println("Q16: " + mostFrequentElement(List.of(1, 2, 2, 3, 3, 3)));
        System.out.println("Q17: " + anagramGroups(List.of("bat", "tab", "cat", "act", "dog")));
        System.out.println("Q18: " + multiplyAllOddNumbers(List.of(1, 2, 3, 4, 5)));
        System.out.println("Q19: " + nthLargest(List.of(10, 30, 20, 40, 50), 3));
        System.out.println("Q20: " + slidingWindowSums(List.of(1, 2, 3, 4, 5), 3));
    }

    // Easy
    public static long countEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(num -> num % 2 == 0).count();
    }

    public static List<Integer> squareEachElement(List<Integer> numbers) {
        return numbers.stream().map(x -> x * x).toList();
    }

    public static List<String> filterStringsStartingWithA(List<String> strings) {
        return strings.stream().filter(x -> x.startsWith("A") || x.startsWith("a")).collect(Collectors.toList());
    }

    public static int sumOfList(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public static List<Integer> distinctSortedValues(List<Integer> numbers) {
        return numbers.stream().distinct().sorted().collect(Collectors.toList());
    }

    // Medium
    public static String joinWithDash(List<String> words) {
        return words.stream().collect(Collectors.joining("-"));
    }

    public static Map<String, Long> countOccurrences(List<String> words) {
        return words.stream().collect(Collectors.toMap(k -> k, v -> 1L, Long::sum));
    }

    public static Optional<Integer> findMaxNumber(List<Integer> numbers) {
        return numbers.stream().max(Comparator.comparing(Integer::intValue));
    }

    public static boolean allElementsGreaterThanZero(List<Integer> numbers) {
        return numbers.stream().noneMatch(x -> x < 0);
    }

    public static Map<Boolean, List<Integer>> partitionByEvenOdd(List<Integer> numbers) {
        return numbers.stream().collect(Collectors.partitioningBy(x -> x%2 == 0));
    }

    // Medium-Hard
    public static Map<Integer, List<String>> groupByStringLength(List<String> words) {
        return words.stream().collect(Collectors.groupingBy(String::length));
    }

    public static List<Integer> flattenListOfLists(List<List<Integer>> nestedList) {
        return nestedList.stream().flatMap(Collection::stream).toList();
    }

    public static Map<String, Integer> wordLengthMap(List<String> words) {
        return words.stream().collect(Collectors.toMap(k -> k, String::length));
    }

    public static List<String> top3LongestStrings(List<String> words) {
        return words.stream().sorted(Comparator.comparing(String::length).reversed()).limit(3).toList();
    }

    public static Map<Integer, Long> frequencyMap(List<Integer> numbers) {
        return numbers.stream().collect(Collectors.toMap(k -> k, v -> 1L, Long::sum));
    }

    // Hard
    public static Optional<Integer> mostFrequentElement(List<Integer> numbers) {
        return Optional.empty();
    }

    public static List<List<String>> anagramGroups(List<String> words) {
        return null;
    }

    public static int multiplyAllOddNumbers(List<Integer> numbers) {
        return numbers.stream().filter(x -> x % 2 == 1).reduce(1, (a, b) -> a * b);
    }

    public static Optional<Integer> nthLargest(List<Integer> numbers, int n) {
        return numbers.stream().sorted(Comparator.reverseOrder()).skip(n-1).findFirst();
    }

    public static List<Integer> slidingWindowSums(List<Integer> numbers, int windowSize) {
        return null;
    }

    public Map<Integer, List<Person>> groupByAge(List<Person> list) {
        return list.stream().collect(Collectors.groupingBy(Person::getAge));
    }
}
